package day2;

public class IncomeTaxSlab {
    public static void main(String[] args) {
        double[] annual = {12.5,9.2,4.5,19.5,2.5,56.8};
        for(int index = 0;index<annual.length;index++){
            if(annual[index]>4&&annual[index]<8)
                annual[index]-=(annual[index]*0.050);
            else if(annual[index]>=8&&annual[index]<12)
                annual[index]-=(annual[index]*0.100);
            else if(annual[index]>=12&&annual[index]<16)
                annual[index]-=(annual[index]*0.150);
            else if(annual[index]>=16&&annual[index]<20)
                annual[index]-=(annual[index]*0.200);
            else if(annual[index]>=20&&annual[index]<24)
                annual[index]-=(annual[index]*0.250);
            else if(annual[index]>=24)
                annual[index]-=(annual[index]*0.300);
            
            System.out.println(annual[index]);
        }
    }
}
