import java.util.concurrent.Callable;

/*
 * Add missing code to Chicken and Egg so the following actions are completed:
 *
 *  Chicken implements the IBird interface.
 *  Chicken lays an egg that hatches into other chicken.
 *  Eggs from other types of birds should hatch into that type of bird.
 *  Hatching an egg for the second time throws a IllegalStateException.
 */


interface IBird {
    Egg Lay();
}   

class Chicken implements IBird { 
    public Chicken() {       
    }

    public Egg Lay() {
        return new Egg();
    }
    
    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof IBird);
    }
}

class Egg { 
    public Egg(Callable<IBird> createBird) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    
    public IBird Hatch() throws Exception {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }
}

/*
 *  Chicken is an IBird: Wrong answer
 *  Chickens make other chickens: java.lang.ClassCastException
 *  Other birds don't make chickens: java.lang.UnsupportedOperationException at Egg.(Chicken.java:19)
 * Eggs can't hatch twice: java.lang.ClassCastException 
 */
