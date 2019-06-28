package com.example.abdullahal_munzir.twoscomplement;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RootActivity extends AppCompatActivity {


    RadioGroup rg_inp, rg_out;
    RadioButton bin, dec, oct, hex, binOut, decOut, octOut, hexOut;
    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 , button_complement, button_conversion,
            button7 , button8 , button9 , buttonA, buttonB , buttonC ,
            buttonD , buttonE , buttonF , buttonCal, buttonMinus, buttonClear, buttonBackspace;

    TextView input, output;
    public boolean mode=true, small_text=false, landscape;

    public int digit_count=1, check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Remove title bar
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);

            //Remove notification bar
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            //set content view AFTER ABOVE sequence (to avoid crash)
            this.setContentView(R.layout.activity_root);
        }
        else {
            setContentView(R.layout.activity_root);
        }

        check=10;

        rg_inp=(RadioGroup) findViewById(R.id.inp_radio_group);
        rg_out=(RadioGroup) findViewById(R.id.out_radio_group);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);

        buttonCal = (Button) findViewById(R.id.buttonCal);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonMinus = (Button) findViewById(R.id.buttonminus);
        button_complement = (Button) findViewById(R.id.button_complement);
        button_conversion = (Button) findViewById(R.id.button_conversion);

        bin = (RadioButton) findViewById(R.id.binary_r);
        dec = (RadioButton) findViewById(R.id.decimal_r);
        oct = (RadioButton) findViewById(R.id.octal_r);
        hex = (RadioButton) findViewById(R.id.hex_r);

        binOut = (RadioButton) findViewById(R.id.out_binary_r);
        decOut = (RadioButton) findViewById(R.id.out_decimal_r);
        octOut = (RadioButton) findViewById(R.id.out_octal_r);
        hexOut = (RadioButton) findViewById(R.id.out_hex_r);




        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);


        //buttonMinus.setEnabled(false);

        final Context context = getApplicationContext();
        final int duration = Toast.LENGTH_SHORT;



        button_complement.setOnClickListener(
                new Button.OnClickListener(){
                    public  void onClick(View v){
                        if(!mode) {
                            //button_conversion.setBackgroundColor(Color.parseColor("#FFECEFF1")); //white
                            // button_complement.setBackgroundColor(Color.parseColor("#ff00ddff")); //blue
                            button_complement.setBackgroundResource(R.drawable.compl_on);
                            button_complement.setTextColor(Color.parseColor("#ffffff"));

                            button_conversion.setTextColor(Color.parseColor("#ff00ddff"));
                            button_conversion.setBackgroundResource(R.drawable.conv_off);
                            mode=true;

                            Toast toast = Toast.makeText(context, "2's Complement mode activated", Toast.LENGTH_SHORT);
                            toast.show();
                            all_clear();

                        }}});


        button_conversion.setOnClickListener(
                new Button.OnClickListener(){
                    public  void  onClick(View v){
                        // button_complement.setBackgroundColor(Color.parseColor("#FFECEFF1")); //white
                        //button_conversion.setBackgroundColor(Color.parseColor("#ff00ddff")); // blue
                        button_conversion.setBackgroundResource(R.drawable.conv_on);
                        button_conversion.setTextColor(Color.parseColor("#ffffff"));

                        button_complement.setTextColor(Color.parseColor("#ff00ddff"));
                        button_complement.setBackgroundResource(R.drawable.comple_off);
                        buttonMinus.setEnabled(true);
                        mode=false;

                        Toast toast = Toast.makeText(context, "Conversion mode activated", Toast.LENGTH_SHORT);
                        toast.show();
                        all_clear();
                    }});


        bin.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                            Toast toast = Toast.makeText(context, "Selected Binary as input type", Toast.LENGTH_SHORT);
                            toast.show();
                            all_clear();
                            check=31;
                    }});

        dec.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Decimal as input type", Toast.LENGTH_SHORT);
                        toast.show();
                        all_clear();
                        check=10;
                    }});

        oct.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Octal as input type", Toast.LENGTH_SHORT);
                        toast.show();
                        all_clear();
                        check=11;
                    }});

        hex.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Hexadecimal as input type", Toast.LENGTH_SHORT);
                        toast.show();
                        all_clear();
                        check=8;
                    }});


        binOut.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Binary as output type", Toast.LENGTH_SHORT);
                        toast.show();
                        output_clear();
                    }});

        decOut.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Decimal as output type", Toast.LENGTH_SHORT);
                        toast.show();
                        output_clear();
                    }});

        octOut.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Octal as output type", Toast.LENGTH_SHORT);
                        toast.show();
                        output_clear();
                    }});

        hexOut.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Toast toast = Toast.makeText(context, "Selected Hexadecimal as output type", Toast.LENGTH_SHORT);
                        toast.show();
                        output_clear();
                    }});






        buttonClear.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                       all_clear();
                    }});



            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                        input.setText(input.getText() + "1");
                        digit_count++;
                    }
                    else{maximum_limit();}
                }
            });


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                        input.setText(input.getText() + "2");
                        digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "3");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "4");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "5");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "6");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "7");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "8");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "9");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {

                    String str = input.getText().toString();
                    int len = str.length();
                    if (len != 0) {
                        input.setText(input.getText() + "0");
                        digit_count++;
                    }
                    } else {
                        maximum_limit();
                    }
                }
            });

            buttonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "A");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            buttonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "B");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            buttonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "C");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            buttonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "D");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (digit_count <= check) {
                    input.setText(input.getText() + "E");
                    digit_count++;
                        } else {
                            maximum_limit();
                        }
                }
            });

            buttonF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (digit_count <= check) {
                    input.setText(input.getText() + "F");
                    digit_count++;
                    } else {
                        maximum_limit();
                    }
                }
            });

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                    input.setText(str);
                    digit_count--;
                } else if (str.length() <= 1) {
                    input.setText(null);
                    digit_count=1;
                }}});

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radiobtnId=rg_inp.getCheckedRadioButtonId();
                if(!mode && radiobtnId== R.id.decimal_r) {
                    String str = input.getText().toString();
                    int len = str.length();
                    if (len == 0) {
                        input.setText(input.getText() + "-");
                    }}}});


        buttonCal.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        //Context context = getApplicationContext();
                        //CharSequence text;

                        Complement compl= new Complement();

                        int radiobtnId=rg_inp.getCheckedRadioButtonId();
                        int rBtnId=rg_out.getCheckedRadioButtonId();

                        String digit;
                        String res;
                        digit = input.getText().toString();

                        if(radiobtnId== R.id.binary_r) {

                            try {

                                res = compl.BtoD(digit); // checking it binary or not

                                if (mode) {
                                    res = compl.complement(digit); //calling Complement method
                                } else {
                                    res = digit;
                                }

                                if (rBtnId == R.id.out_binary_r) {
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_decimal_r) {
                                    res = compl.BtoD(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_octal_r) {
                                    res = compl.BtoO(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_hex_r) {
                                    res = compl.BtoH(res);
                                    output.setText(res);
                                }
                            } catch (NumberFormatException e) {
                                if (digit.equals("") || digit == null) {
                                    Toast toast = Toast.makeText(context, "No input yet!", duration);
                                    toast.show();
                                    output_clear();
                                } else if (!compl.isBinary(digit)) {
                                    Toast toast = Toast.makeText(context, "Non-binary input!", duration);
                                    toast.show();
                                    output_clear();

                                } else {
                                    Toast toast = Toast.makeText(context, "Out of range!", duration);
                                    toast.show();
                                    output_clear();
                                }
                            }
                        }




                        else if(radiobtnId== R.id.decimal_r) {

                            try {
                                if (mode) {
                                    String bin = compl.DtoB(digit); //calling conversion method
                                    res = compl.complement(bin); //calling Complement method
                                    if (rBtnId == R.id.out_binary_r) {
                                        output.setText(res);
                                    } else if (rBtnId == R.id.out_decimal_r) {
                                        res = compl.BtoD(res);
                                        output.setText(res);
                                    } else if (rBtnId == R.id.out_octal_r) {
                                        res = compl.BtoO(res);
                                        output.setText(res);
                                    } else if (rBtnId == R.id.out_hex_r) {
                                        res = compl.BtoH(res);
                                        output.setText(res);
                                    }
                                } else {

                                    if (rBtnId == R.id.out_binary_r) {
                                        res = compl.DtoB(digit);
                                        output.setText(res);

                                    } else if (rBtnId == R.id.out_decimal_r) {
                                        output.setText(digit);
                                    } else if (rBtnId == R.id.out_octal_r) {
                                        res = compl.DtoO(digit);
                                        output.setText(res);
                                    } else if (rBtnId == R.id.out_hex_r) {
                                        res = compl.DtoH(digit);
                                        output.setText(res);
                                    }

                                }
                            } catch (NumberFormatException e) {
                                if (digit.equals("") || digit == null) {
                                    Toast toast = Toast.makeText(context, "No input yet!", duration);
                                    toast.show();
                                    output_clear();
                                } else if (!compl.isNumeric(digit)) {
                                    Toast toast = Toast.makeText(context, "Non-intereger input!", duration);
                                    toast.show();
                                    output_clear();

                                } else {
                                    Toast toast = Toast.makeText(context, "Out of range!", duration);
                                    toast.show();
                                    output_clear();

                                }
                            }
                        }

                        else if(radiobtnId== R.id.octal_r) {

                            try {
                                String bin = compl.OtoB(digit); //calling conversion method
                                if (mode) {
                                    res = compl.complement(bin); //calling Complement method
                                } else {
                                    res = bin;
                                }

                                if (rBtnId == R.id.out_binary_r) {
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_decimal_r) {
                                    res = compl.BtoD(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_octal_r) {
                                    res = compl.BtoO(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_hex_r) {
                                    res = compl.BtoH(res);
                                    output.setText(res);
                                }
                            } catch (NumberFormatException e) {
                                if (digit.equals("") || digit == null) {
                                    Toast toast = Toast.makeText(context, "No input yet!", duration);
                                    toast.show();
                                    output_clear();
                                } else if (!compl.isOctal(digit)) {
                                    Toast toast = Toast.makeText(context, "Non-octal input!", duration);
                                    toast.show();
                                    output_clear();

                                } else {
                                    Toast toast = Toast.makeText(context, "Out of range!", duration);
                                    toast.show();
                                    output_clear();

                                }
                            }
                        }

                        else if(radiobtnId== R.id.hex_r) {

                            try {
                                String bin = compl.HtoB(digit); //calling conversion method
                                if (mode) {
                                    res = compl.complement(bin);//calling Complement method
                                } else {
                                    res = bin;
                                }

                                if (rBtnId == R.id.out_binary_r) {
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_decimal_r) {
                                    res = compl.BtoD(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_octal_r) {
                                    res = compl.BtoO(res);
                                    output.setText(res);
                                } else if (rBtnId == R.id.out_hex_r) {
                                    res = compl.BtoH(res);
                                    output.setText(res);
                                }
                            } catch (NumberFormatException e) {
                                if (digit.equals("") || digit == null) {
                                    Toast toast = Toast.makeText(context, "No input yet!", duration);
                                    toast.show();
                                    output_clear();
                                } else if (!compl.isHexa(digit)) {
                                    Toast toast = Toast.makeText(context, "Non-hexadecimal input!", duration);
                                    toast.show();
                                    output_clear();

                                } else {
                                    Toast toast = Toast.makeText(context, "Out of range!", duration);
                                    toast.show();
                                    output_clear();

                                }
                            }
                        }

                    }
                }
        );

    }

    public void all_clear() {

        input.setText(null);
        output.setText(null);
        digit_count=1;
    }

    public void output_clear() {
        output.setText(null);
    }

    public  void maximum_limit(){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "Maximum Digit Entered", duration);
        toast.show();
    }
}

