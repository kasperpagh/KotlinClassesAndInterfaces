package kasper.pagh.classesandinterfaceskotlin

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * Created by kaspe on 2016-12-07.
 */


open class Person(val name: String, var age : Int, val ctx : Context) : HumanInterface
{

    override fun takeAStep()
    {
        ctx.toast("the person takes a step!")
    }

    constructor(name: String,  age: Int, ctx : Context, isFelmale: Boolean) : this(name, age, ctx)
    {
        //Constuctor overload. Sekundære constructors skal bruge den opridelige constructor, denne refereres som this.
    }
    init
    {
        //Dette er init kode, det bliver altid kørt før constuctors.
    }

}