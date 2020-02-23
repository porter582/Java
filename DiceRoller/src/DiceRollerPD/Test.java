
package DiceRollerPD;

import DiceRollerPD.DiceBag;

public class Test
{
    public static void main(String[] args)
    {
        DiceBag dicebag = new DiceBag(10, 6);
        dicebag.roll();
        System.out.println(dicebag.toString());
        dicebag.frequencyTest();
    }
}