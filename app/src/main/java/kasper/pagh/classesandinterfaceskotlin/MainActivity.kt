package kasper.pagh.classesandinterfaceskotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//extention method
fun Context.toast(message: String)
{
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val polyMorph : HumanInterface

        val student1 = Student("Pelle Von Knygelbrehchen", 12, this, 15)

        polyMorph = student1
        toast("velkommen!")
        student1.StudentCard().getDiscount()

        //ANKO lol
        textView.setText(student1.name)

    }
}
