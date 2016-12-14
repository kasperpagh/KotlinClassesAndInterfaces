### Classes og Interfaces i Kotlin Gruppe 6 (Pelle & Kasper)
**Deklaration af klasser**

Klasser i Kotlin laves på følgende vis: 

```kotlin
open class Person(val name: String, var age : Int, val ctx : Context) : HumanInterface
{
}
```
val (read only, efter den er blevet initialiseret) name og var (alm. variabel) og ctx er de tre constructor parametre. Det vil altså sige, at den primære constructor deklareres i class headeren lige efter klassens navn. 
Når vi i vores constructor bruge val og var, er det for at vise at man også her kan vælge om man må ændre på argumenterne eller ej.


Klassen er deklareret som open, hvilket tillader at andre klasser kan arve fra den. Denne beslutning er taget ud fra devisen: “Design and document for inheritance or else prohibit it.”.
Altså skal en klasse være open førend, det kan lade sig gøre at arve derfra (det samme gør sig forresten gældende med funktioner, de skal deklareres som open fun, hvis de skal kunne overrides).


Det er, ligesom i Java, muligt at overloade en klasses constructor, det gøres på følgende vis:
```kotlin
constructor(name: String,  age: Int, ctx : Context, isFelmale: Boolean) : this(name, age, ctx)
{
   //Constuctor overload. Sekundære constructors skal bruge den opridelige constructor, denne refereres som this.
}
```
Du kan lave så mange constructors du vil i en klasse.

**Arv**

Arv i kotlin fungere efter følgende syntaks:

```kotlin
class Student(name: String, age: Int, ctx: Context, klasse: Int) : Person(name, age, ctx), HumanInterface
```
Ovenstående er en klasse, Student, som extender Person og implementere interfacet HumanInterface. Du kan, ligesom i Java, kun arve fra en klasse, men implementere så mange interfaces du har lyst til (komma separeret). 


Når du laver constructoren til ting der extender, skal de kalde deres supers constructor (ovenfor er det Person(name,age,ctx). Derudover kan de selvfølgelig have lige så mange ekstra parametre som det skal være. Man behøver ikke at bruge extends eller implements, da kotlin selv finder ud af hvad det er.
**Inner Classes**
Med inner classes kan vi lave klasser som har kendskab til outerklassen variable. Dette gør at du kan tilgå dem i innerklassen, og fx lave funktioner som skal bruge variable fra outerklassen.
Dette kan ses i eksemplet herunder.
```kotlin
inner class StudentCard
{
   fun getDiscount()
   {
       ctx.toast("Tillykke med rabatten: ${name}")
   }
}
```
Da inner class StudentCard befinder sig i Student klassen, kan vi kalde den således:
```kotlin
student1.StudentCard().getDiscount()
```


**Interfaces**
Interfaces deklareres således:
interface HumanInterface{fun takeAStep()}
Interfaces må her gerne have simple implementationer som fx en Log, eller lignende. Man kan godt deklarere variable men ikke give dem værdi.

En klasse som implementere flere interfaces med samme metode kan som i eksemplet nedenunder se således ud.
```kotlin
interface HumanInterface
{
   fun takeAStep()
   {
       Log.d("HumanInterface"," takeAStep er blevet kaldt")
   }
   fun tester()
}
interface SecondHumanInterface
{
   fun takeAStep()
   {
       Log.d("SecondHumanInterface"," takeAStep er blevet kaldt")
   }
   fun tester()
   {
       Log.d("Jeg kan ", " godt lide Saybia")
   }
}
class InterfaceOverrider : HumanInterface, SecondHumanInterface
{
   override fun takeAStep()
   {
       super<HumanInterface>.takeAStep()
       super<SecondHumanInterface>.takeAStep()
   }
}
```
I dette eksempel kan vi se at hvis de 2 interfaces har samme metode, men med 2 forskellige implementationer, er vi nødt til at override og fortælle hvilken implementation(eller begge) vi vil bruge. Hvis kun den ene metode har en implementation er kotlin klog nok til selv at finde ud af hvilken en den skal bruge.


**Instantiering af klasser**
Skal man lave kotlin objekter, gøres det på følgende vis:
```kotlin
val student1 = Student("Pelle Von Knygelbrehchen", 12, this, 15)
```
Bemærk at det ikke er nødvendigt at specificere en datatype, samt at der ikke er noget new keyword.
Polymorfi kan laves på følgende måde:
```kotlin
val polyMorph : HumanInterface
polyMorph = student1
```
Hvor student1 er en instans af Student klassen, der implementerer HumanInterface
