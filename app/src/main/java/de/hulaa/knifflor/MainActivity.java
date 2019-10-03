package de.hulaa.knifflor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void rollDice(View view){


        int nOfDices = 5;
        int nOfSides = 6;

        List<ImageView> dices = new ArrayList<ImageView>();

        for(int i=0; i<nOfDices; i++){
            String idName = "imageView"+i;
            System.out.println(idName);
            int resID = getResources().getIdentifier(idName,"id",getPackageName());
            dices.add((ImageView)findViewById(resID));
        }


        Player p = new Player(new Dice(nOfSides));

        Result r = p.rollDices(nOfDices);

        for(int i=0; i<r.values.length;i++){

            System.out.println("Setting dice:"+i);
            switch (r.values[i]){

                case 1:
                    dices.get(i).setImageResource(R.drawable.one);
                    break;
                case 2:
                    dices.get(i).setImageResource(R.drawable.two);
                    break;
                case 3:
                    dices.get(i).setImageResource(R.drawable.three);
                    break;
                case 4:
                    dices.get(i).setImageResource(R.drawable.four);
                    break;
                case 5:
                    dices.get(i).setImageResource(R.drawable.five);
                    break;
                case 6:
                    dices.get(i).setImageResource(R.drawable.six);
                    break;
            }
        }


        TextView t = findViewById(R.id.result);
        String s = "You scored a ";
        if(r.isKniffel()){

        t.setText(s+"Kniffel!");

        }else if(r.isBigStreet()){
            t.setText(s+"big street!");


        }else if(r.isSmallStreet()){

            t.setText(s+"small street!");


        }else if(r.isFullHouse(3,2)){
            t.setText(s+"full house!");

        }else if(r.isOfKind4()){
            t.setText(s+"four of a kind!");

        }else if(r.isOfKind3()){
            t.setText(s+"three of a kind!");

        }else{
            t.setText(s+r.arraySum(r.values)+" points chance!");

        };







    }
}
