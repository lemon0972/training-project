import java.util.Random;

public class Horse extends Thread {
    private String nameH;
    private int lenght = 0;
    private int step = 0;

    public Horse(String nameH){
        this.nameH = nameH;
    }
    public void run(){
        try{
            sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        while(lenght != 100){
            Random randomNumber = new Random();
            lenght += randomNumber.nextInt(10)+1;
            step += 1;
            System.out.println(nameH + ": " + step);
        } if (lenght >100){
            lenght -= 100;
        }
        System.out.println("con ngua" + nameH + " ve dich voi" + step + "buoc");
    }
    public int getLenght(){
        return this.lenght;
    }
    public int getStep(){
        return step;
    }
    public String nameH(){
        return nameH;
    }
}

