import java.util.Random;

public class App {
    int n=6; 
    double x[]; 
    double y[]; 
    double v[]; 
    double c1=2; 
    double c2=2;
    double omega=0.4;
    double pbest_x[]; 
    double pbest_y[];
    double gbest_x; 
    double gbest_y;
    double vmax=0.1;
    
    public double targetFunction(double arg){
        return -arg*(arg-2);
    }

    
    public void fitnessFunction(){
        for(int i=0;i<n;i++){
            y[i]=-x[i]*(x[i]-2);
        }
    }

   
    public void init(){
        x=new double[n];
        y=new double[n];
        v=new double[n];
        pbest_x=new double[n];
        pbest_y=new double[n];

        for(int i=0;i<n;i++){
            x[i]=(Math.random()-0.5)*5;
            v[i]=Math.random()*0.1;
        }
        
        for(int i=0;i<n;i++){
            pbest_x[i]=x[i];
            pbest_y[i]=targetFunction(x[i]);
            if(targetFunction(x[i])>gbest_y){
                gbest_x=x[i];
                gbest_y=targetFunction(gbest_x);
            }
        }
        System.out.println("PSO start:"+gbest_y);
        System.out.println("\n");
    }


    public double getMAX(double a,double b){
        return a>b?a:b;
    }

    public void PSO(int max){
        
        for(int i=0;i<max;i++){
            
            for(int j=0;j<n;j++){
               
                v[j]=omega*v[j]+c1*Math.random()*(pbest_x[j]-x[j])+c2*Math.random()*(gbest_x-x[j]);
                
                if(v[j]>vmax){
                    v[j]=vmax;
                }
                
                x[j]+=v[j];
                
                if(x[j]<0) x[j]=0;
                if(x[j]>2) x[j]=2;
            }
            fitnessFunction();
            
            for(int j=0;j<n;j++){
                pbest_y[j]=getMAX(targetFunction(x[j]), pbest_y[j]);
                if(pbest_y[j]>gbest_y){
                    gbest_y=pbest_y[j];
                    gbest_x=x[j];
                }
                System.out.println("particle"+j+": x = "+x[j]+"  "+"v = "+v[j]);
            }
            System.out.println("this is "+(i+1)+" epoch，gbset is ("+gbest_x+","+gbest_y+")");
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        App test=new App();
        test.init();
        test.PSO(40);
    }
}
