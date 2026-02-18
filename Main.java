public class Main {
    public static void main(String[] args) {

        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Mittens"));
        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Whiskers"));

        System.out.println(shelter.dequeueAny().getName()); // Rex
        System.out.println(shelter.dequeueCat().getName()); // Mittens
        System.out.println(shelter.dequeueDog().getName()); // Buddy
        System.out.println(shelter.dequeueAny().getName()); // Whiskers
    }
}