package model;


public class TestUser{
    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private String number;
    private int group;

//    public TestUser (int id, String first_name, String last_name, int age, String number,
//              int group){
//        this.id = id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.age = age;
//        this.number = number;
//        this.group =group;
//    }

    public TestUser(){

    }

    public int getId(){
        return this.id;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getFull_name(){
        return this.first_name.concat(" ").concat(this.last_name);
    }

    public int getAge() {
        return this.age;
    }

    public String getNumber() {
        return this.number;
    }

    public int getGroup() {
        return this.group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
