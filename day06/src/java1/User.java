package java1;

import java.util.Objects;

/**
 * @author yjh 1600063206@qq.com
 * @version 2023/5/10 15:55
 * @since JDK8
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User(){
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("User equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        int result =name !=null ? name.hashCode() :0;
        result = 31 * result + age;
        return result;
//        return Objects.hash(name, age);
    }

    //按照姓名从小到大排列
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user =(User)o;
//            return -this.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if(compare !=0){
                return compare;
            }else {
                return Integer.compare(this.age,user.age);
            }
        }else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}