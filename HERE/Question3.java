package HERE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Gender {
    MALE, FEMALE, UNKNOWN;
}

class User {
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    public User(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    /**
     * AUTOGENERATED GETTER - SETTER
     * **/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

class Implementation {
    public String join(List<User> list) {
        List<User> users = list.stream()
                .filter(user -> user.getAge() > 23)
                .collect(Collectors.toList());

        String result = users.stream()
                .flatMap(user -> Stream.of(user.getFirstName()))
                .collect(Collectors.joining(" and ", "In USA ", " can buy alcohol"));

        return result;
    }

    public User longestLastName(List<User> list) {
       User reqUser = null;

       for(User user : list) {
           if(reqUser==null) {
               reqUser = user;
           } else if (reqUser.getLastName().length() < user.getLastName().length()) {
               reqUser = user;
           }
       }

       return reqUser;
    }

    public String capitalizeLastName(List<User> list) {

        return list.stream()
                .flatMap(user -> Stream.of(user.getLastName().toUpperCase()))
                .collect(Collectors.joining(", "));
    }
}

public class Question3 {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Scarlet", "FutureAndPromises", 24, Gender.FEMALE));
        list.add(new User("Test", "JasSON", 21, Gender.FEMALE));
        list.add(new User("Test2", "LONE", 26, Gender.FEMALE));

        Implementation implementation = new Implementation();
        System.out.println(implementation.join(list));
        System.out.println(implementation.longestLastName(list));
        System.out.println(implementation.capitalizeLastName(list));
    }
}
