package po.crawler.web.project;

public class Boots {

    private String name;
    private int add1 ;
    private int add2 ;
    private int add3 ;
    private int add4 ;

    private int pointer = -1;


    public void Boots(int number){
        if(number > GetLOL.boots.size()-1 || number < 0);
        else{
            this.name=GetLOL.boots.get(number);
            this.pointer=number;
        }
    }
    public void changeup(){
        if(pointer < GetLOL.boots.size()-1){
            pointer++;
            Boots(pointer);
           setteradds();

        }
        else{
            pointer=-1;
            changeup();
        };

    }

    public void changedown(){
        if(pointer > 0){
            pointer--;
            Boots(pointer);
          setteradds();
        }
        else{
            pointer=GetLOL.boots.size();
            changedown();
        }

    }

    public void setteradds(){
        int j = GetLOL.boots_attr.get(name).size();
        int tab[] = {0,0,0,0};
        for(int i =0 ; i < j ; i++) {
            if (i == 3) {
                break;
            } else {
                int z = GetLOL.boots_attr.get(name).get(i).indexOf(" ");
                int tmp = Integer.parseInt(GetLOL.boots_attr.get(name).get(i).substring(0, z));
                if (tmp == 1) {
                    tab[i] = 50;
                } else {
                    tab[i] = tmp;
                }
            }
        }
        this.add1=tab[0];
        this.add2=tab[1];
        this.add3=tab[2];
        this.add4=tab[3];
    }

    public String getName() {
        return name;
    }

    public int getAdd1() {
        return add1;
    }

    public int getAdd2() {
        return add2;
    }

    public int getAdd3() {
        return add3;
    }

    public int getAdd4() {
        return add4;
    }

    public void reset(){
        this.add1=0;
        this.add2=0;
        this.add3=0;
        this.add4=0;
    }
}
