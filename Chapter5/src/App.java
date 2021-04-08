public class App {
    public static void main(String[] args) throws Exception {
        Village zhao =new Village("VillageZhao");
        Village ma = new Village("VillageMa");
        zhao.peoplenumber=100;
        ma.peoplenumber=150;
        Village.treeamount=200;
        int lefttrees=Village.treeamount;
        System.out.println("There are "+lefttrees+" trees in the forest");
        zhao.plantTree(50);
        lefttrees=ma.getTreeAmount();
        System.out.println("There are "+lefttrees+" trees in the forest");
        ma.fellTree(70);
        lefttrees=ma.getTreeAmount();
        System.out.println("There are "+lefttrees+" trees in the forest");
        System.out.println("The population of the VillageZhao "+zhao.peoplenumber);
        zhao.addPeopleNumber(12);
        System.out.println("The population of the VillageZhao "+zhao.peoplenumber);
        System.out.println("The population of the VillageMa "+ma.peoplenumber);
        ma.addPeopleNumber(10);
        System.out.println("The population of the VillageMa "+ma.peoplenumber);
    }
}

class Village{
    static int treeamount;
    int peoplenumber;
    String name;
    Village(String s){
        name = s;
    }
    void plantTree(int n){
        treeamount +=n;
        System.out.println(name+" plants "+n+" trees");
    }
    void fellTree(int n){
        if(treeamount - n >=0){
            treeamount -=n;
            System.out.println(name+" fells "+n+" trees" );
        }else{
            System.out.println("no trees to fell!");
        }
    }
    int getTreeAmount(){
        return treeamount;
    }
    void addPeopleNumber(int n){
        peoplenumber+=n;
        System.out.println(name+" add "+n+" people ");
    }
}