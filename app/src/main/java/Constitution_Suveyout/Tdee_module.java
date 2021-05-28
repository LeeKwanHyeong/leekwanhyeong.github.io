package Constitution_Suveyout;

public class Tdee_module {
    double weight,height,percentage_of_body_fat,fat_mass,body_mass;
    int age,sex,trauma,burn,activity_index,pal;
    public double getWeight()
    {
        return weight;
    }
    public void setWeight(double weight)
    {
        this.weight = weight;
    }
    public double getHeight()
    {
        return height;
    }
    public void setHeight(double height)
    {
        this.height = height;
    }
    public double getPercentage_of_body_fat()
    {
        return percentage_of_body_fat;
    }
    public void setPercentage_of_body_fat(double percentage_of_body_fat)
    {
        this.percentage_of_body_fat = percentage_of_body_fat;
    }
    public double getFat_mass()
    {
        return fat_mass;
    }
    public void setFat_mass(double fat_mass)
    {
        this.fat_mass = fat_mass;
    }
    public double getBody_mass()
    {
        return body_mass;
    }
    public void setBody_mass(double body_mass)
    {
        this.body_mass = body_mass;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex)
    {
        this.sex = sex;
    }
    public int getTrauma()
    {
        return trauma;
    }
    public void setTrauma(int trauma)
    {
        this.trauma = trauma;
    }
    public int getBurn()
    {
        return burn;
    }
    public void setBurn(int burn)
    {
        this.burn = burn;
    }
    public int getActivity_index()
    {
        return activity_index;
    }
    public void setActivity_index(int activity_index)
    {
        this.activity_index = activity_index;
    }
    public int getPal()
    {
        return pal;
    }
    public void setPal(int pal)
    {
        this.pal = pal;
    }
    //HARRIS AND BENEDICT EQUATION
    public double BMR_module(double sex, double age,double weight,double height)
    {
        double bmr=0;
        if(sex==1) {
            bmr=88.362+(13.397*weight)+(4.799*height)-(5.677*age);
        }
        else if(sex==2) {
            bmr=477.593+(9.247*weight)+(3.098*height)-(4.330*age);
        }
        return bmr;
    }
    public double REE_common(double sex, double age,double weight,double height)
    {
        double ree=0;
        if(sex==1) {
            ree=66.47+(13.75*weight)+(5*height)-(6.8*age);
        }
        else if(sex==2) {
            ree=655+(9.6*weight)+(1.8*height)-(4.7*age);
        }
        return ree;
    }
    public double REE_revised(double sex, double age, double weight, double height)
    {
        double ree=0;
        if(sex==1) {
            ree=88.362+(13.397*weight)+(4.799*height)-(5.677*age);
        }
        else if(sex==2) {
            ree=447.593+(9.247*weight)+(3.098*height)-(4.330*age);
        }
        return ree;
    }
    public double REE_obesity(double sex, double age,double weight,double height)
    {
        double ree=0;
        if(sex==1) {
            ree=(10*weight)+(6.3*height)-(5*age)+5;
        }
        else if(sex==2) {
            ree=(10*weight)+(6.3*height)-(5*age)-161;
        }
        return ree;
    }
    public double TEF(double sex,double age,double weight,double height)
    {
        double tef=0;
        double ree=BMR_module(sex,age,weight,height);
        tef=ree*0.1;
        return tef;
    }
    public double FM(double weight,double percentage_of_body_fat)
    {
        double fm=weight*(percentage_of_body_fat/100);
        return fm;
    }
    public double FMP(double weight,double fat_mass)
    {
        double fmp=(fat_mass/weight)*100;
        return fmp;
    }
    public double BMI(double weight, double height)
    {
        double bmi=weight/(Math.pow(height, 2));
        return bmi;
    }
    public double LBM(double body_mass,double fat_mass)
    {
        return body_mass-fat_mass;
    }
    /*public double EEE_v(int age, int sex, int trauma, int burn,double weight)
    {
        double eeev=1925-(10*age)+(5*weight)+(281*sex)+(292*trauma)+(851*burn);
        return eeev;
    }*/
	/*public double EEE_s(int age, double weight, double bmi)
	{
		int check=0;
		if(bmi>24.0) check=1;
		else check=0;
		double eees=629-(11*age)+(25*weight)-(609*check);
		return eees;

	}*/

    /*public int EEE(ArrayList pal) {
        int output=0;
        if(pal.get(0)==1.0) output=250;
        else if(pal[0]==2.0) output=350;
        else if(pal[0]==3.0) output=450;
        return output;
    }*/

    public int NEAT(double pal_index_num) {
        int output=0;
        if (pal_index_num==1.0) output=250;
        else if (pal_index_num==2.0) output=350;
        else if (pal_index_num==3.0) output=450;
        return output;
    }
}
