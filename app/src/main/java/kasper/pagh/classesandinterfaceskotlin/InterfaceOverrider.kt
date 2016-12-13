package kasper.pagh.classesandinterfaceskotlin

import android.util.Log

/**
 * Created by kaspe on 2016-12-13.
 */
class InterfaceOverrider : HumanInterface, SecondHumanInterface
{
    override fun takeAStep()
    {
        super<HumanInterface>.takeAStep()
        super<SecondHumanInterface>.takeAStep()
    }
}
