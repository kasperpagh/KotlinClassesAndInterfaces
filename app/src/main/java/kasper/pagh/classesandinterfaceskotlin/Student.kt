package kasper.pagh.classesandinterfaceskotlin

import android.content.Context

/**
 * Created by kaspe on 2016-12-08.
 */
class Student(name: String, age: Int, ctx: Context, klasse: Int) : Person(name, age, ctx), HumanInterface, SecondHumanInterface
{
    override fun takeAStep()
    {
        //Normalt skulle man skrive følgende, hvis man ikke extender Person:
        //super<HumanInterface>.takeAStep()
        //Men da vores superklasse allerede implementere denne metode, skal vi blot kalde supers implementation
        super<Person>.takeAStep()
        super<SecondHumanInterface>.takeAStep()
    }
    inner class StudentCard
    {
        fun getDiscount()
        {
            ctx.toast("Tillykke med rabatten: ${name}")
        }
    }
}