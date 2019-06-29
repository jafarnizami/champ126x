package com.example.calculator10

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn0 -> displaynum(0)
            R.id.btn1 -> displaynum(1)
            R.id.btn2 -> displaynum(2)
            R.id.btn3 -> displaynum(3)
            R.id.btn4 -> displaynum(4)
            R.id.btn5 -> displaynum(5)
            R.id.btn6 -> displaynum(6)
            R.id.btn7 -> displaynum(7)
            R.id.btn8 -> displaynum(8)
            R.id.btn9 -> displaynum(9)
            R.id.btnadd -> displayop('+')
            R.id.btnsub -> displayop('-')
            R.id.btnmul -> displayop('*')
            R.id.btndiv -> displayop('/')
            R.id.btndot-> shinput=false
            R.id.btnsqroot-> {
                tv3.text="√"

                tvres.text= Math.sqrt(f1).toString()
            }

            R.id.btneq -> {
                val result = calcLogic.evaluate(f1, f2, op)
                shinput=true
                mem=result
                tvres.text = result.toString()
            }
            R.id.btnc -> {
                f1 = 0.0
                tv1.text = ""
                f2 = 0.0
                tv2.text = ""
                op = '$'
                tv3.text = ""
                tvres.text = ""
                input=true
                shinput=true
                Toast.makeText(this,"CLEARED",Toast.LENGTH_SHORT).show()

            }

            R.id.btnsq-> {
                tv3.text="SQAURE"
                tvres.text = (f1 * f1).toString()
            }

            R.id.btnper-> {
                tv3.text="%"
                tvres.text = (f1 * 0.01).toString()

            }
        }

    }

    private var f1 = 0.0
    private var f2 = 0.0
    private var op = '$'
    var input = true
    var shinput=true
    var mem=0.0
    var t=0.0
    private var calcLogic = CalcLogic()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attach()

    }

    private fun attach() {

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnadd.setOnClickListener(this)
        btnsub.setOnClickListener(this)
        btnmul.setOnClickListener(this)
        btndiv.setOnClickListener(this)
        btneq.setOnClickListener(this)
        btnc.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnper.setOnClickListener(this)
        btnsq.setOnClickListener(this)
        btnsqroot.setOnClickListener(this)
        btndot.setOnClickListener(this)
    }

    private fun displaynum(num: Int) {
        if (op != '$'&& shinput==true) {
            f2 = f2 * 10 + num
            tv2.text = f2.toString()
        }
        else if (shinput==false)
        {
            if (op != '$') {
                f2 = (f2 * 10 + num)/10
                tv2.text = f2.toString()
            }
            else
            {
                f1= (f1 * 10 + num)/10
                tv1.text = f1.toString()
                shinput=true
            }

        }
        else {
            f1 = f1 * 10 + num
            tv1.text = f1.toString()
        }
    }

    private fun displayop(Operator: Char) {

        if (input == true) {
            op = Operator
            tv3.text = op.toString()
            input=false
        }
        else
        {
            op=Operator
            tv1.text=tvres.text.toString()
            f1=mem
            tv2.text=""
            f2=0.0
            tv3.text=op.toString()
            tvres.text=""
        }

    }

}




