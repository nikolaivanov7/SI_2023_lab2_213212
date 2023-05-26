import java.util.List;
class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){//A
            throw new RuntimeException("Mandatory information missing!");//B
        }

        if (user.getUsername()==null){//C
            user.setUsername(user.getEmail());//D
        }

        int same = 1;//E
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//F
            same = 0;//G
            for (int i=0;i<allUsers.size();i++) {//H
                User existingUser = allUsers.get(i);//I
                if (existingUser.getEmail() == user.getEmail()) {//J
                    same += 1;//K
                }
                if (existingUser.getUsername() == user.getUsername()) {//L
                    same += 1;//M
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";//O
        String password = user.getPassword();//O
        String passwordLower = password.toLowerCase();//O

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //P
            return false;//Q
        }
        else {
            if (!passwordLower.contains(" ")) {//R
                for (int i = 0; i < specialCharacters.length(); i++) {//S
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {//T
                        return same == 0;//U
                    }
                }
            }
        }
        return false;//V
    }

}
