public class Character {
    public String name = "";
    public String height = "";
    public String birth_year = "";

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", birth year='" + birth_year + '\'' +
                '}';
    }


    public  Character(String pName, String pHeight, String pBirthYear){
            this.name = pName;
            this.height = pHeight;
            this.birth_year = pBirthYear;
    }

    public Object[] toObjectArray(){
        return new Object[] {this.name, this.height, this.birth_year};
    }



}
