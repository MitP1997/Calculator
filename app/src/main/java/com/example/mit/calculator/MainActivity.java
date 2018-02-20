package com.example.mit.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{
    String val="",temp,t;
    Button b[]=new Button[12];
    Button bt[]=new Button[8];
    TextView txt;
    boolean deci=false,addition=false,subtraction=false,multiplication=false,division=false,addition2=false,subtraction2=false,multiplication2=false,division2=false;
    int i;
    double n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.res);
        b[1]= (Button)findViewById(R.id.one);
        b[2] = (Button)findViewById(R.id.two);
        b[3] = (Button)findViewById(R.id.three);
        b[4] = (Button)findViewById(R.id.four);
        b[5] = (Button)findViewById(R.id.five);
        b[6] = (Button)findViewById(R.id.six);
        b[7] = (Button)findViewById(R.id.seven);
        b[8] = (Button)findViewById(R.id.eight);
        b[9] = (Button)findViewById(R.id.nine);
        b[10] = (Button)findViewById(R.id.zero);
        b[11] = (Button)findViewById(R.id.decimal);
        bt[0]=(Button)findViewById(R.id.ac);
        bt[1]=(Button)findViewById(R.id.pos_neg);
        bt[2]=(Button)findViewById(R.id.percent);
        bt[3]=(Button)findViewById(R.id.divide);
        bt[4]=(Button)findViewById(R.id.multiply);
        bt[5]=(Button)findViewById(R.id.subtract);
        bt[6]=(Button)findViewById(R.id.add);
        bt[7]=(Button)findViewById(R.id.equal);
       for(i=1;i<=11;i++)
       {
           b[i].setOnClickListener(this);
       }
       for(i=0;i<8;i++)
       {
           bt[i].setOnClickListener(this);
       }

    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case (R.id.one):display("1");

                            break;
            case (R.id.two):display("2");
                            break;
            case (R.id.three):display("3");
                break;
            case (R.id.four):display("4");
                break;
            case (R.id.five):display("5");
                break;
            case (R.id.six):display("6");
                break;
            case (R.id.seven):display("7");
                break;
            case (R.id.eight):display("8");
                break;
            case (R.id.nine):display("9");
                break;
            case (R.id.decimal):if(!deci)
            {
                display(".");
                deci=true;
            }
                break;
            case (R.id.zero):display("0");
                break;
            case (R.id.ac):txt.setText("0");
                deci=addition=subtraction=multiplication=division=addition2=subtraction2=multiplication2=division2=false;
                break;
            case (R.id.pos_neg):
                temp=""+txt.getText();
                n1=Float.parseFloat(temp);
                n1=n1*(-1);
                t=String.valueOf(n1);
                txt.setText(t);
                break;
            case (R.id.add):
                subtraction=multiplication=division=subtraction2=multiplication2=division2=false;
                addition=addition2=true;
                temp=""+txt.getText();
                n1=Float.parseFloat(temp);
                break;
            case (R.id.subtract):
                addition=multiplication=division=addition2=multiplication2=division2=false;
                subtraction=subtraction2=true;
                temp=""+txt.getText();
                n1=Float.parseFloat(temp);
                break;
            case (R.id.multiply):
                addition=subtraction=division=addition2=subtraction2=division2=false;
                multiplication=multiplication2=true;
                temp=""+txt.getText();
                n1=Float.parseFloat(temp);
                break;
            case (R.id.divide):
                addition=subtraction=multiplication=addition2=subtraction2=multiplication2=false;
                division=division2=true;
                temp=""+txt.getText();
                n1=Float.parseFloat(temp);
                break;
            case (R.id.equal):
                temp=""+txt.getText();
                n2=Float.parseFloat(temp);
                calc(n1,n2);
                break;
            case (R.id.percent):
                temp=""+txt.getText();
                if((addition||subtraction||multiplication||division))
                {
                n1=Float.parseFloat(temp);
                n1=n1/100;
                t=String.valueOf(n1);
                txt.setText(t);
                }
                else
                {
                    n2=Float.parseFloat(temp);
                    n2=n2/100;
                    t=String.valueOf(n2);
                    txt.setText(t);
                }
                break;
        }
    }

    public void display(String x)
    {
        if(!(addition||subtraction||multiplication||division)) {
            val = "";

            val = val + txt.getText();
            if (val.equals("0")) {
                txt.setText(x);
            } else {
                txt.append(x);
            }
        }
        else
        {
            txt.setText(x);
            addition=subtraction=multiplication=division=false;
        }
    }
    public void calc(double m,double n)
    {
        if(addition2)
            n2=n2+n1;
        else if(subtraction2)
            n2=n1-n2;
        else if(multiplication2)
            n2=n1*n2;
        else if(division2)
            n2=n1/n2;
        else{}
        String result=String.valueOf(n2);
        n1=n2;
        addition=subtraction=multiplication=division=false;
        txt.setText(result);

    }
}
