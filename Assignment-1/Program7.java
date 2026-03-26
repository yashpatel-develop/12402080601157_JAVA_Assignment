// Demonstration of Inner Classes
//Problem Statement:
//Write a Java program demonstrating member inner class, local inner class, and anonymous inner class.
class OuterClass {

    int x = 10;

    // 1️⃣ Member Inner Class
    class MemberInner {

        void display() {
            System.out.println("Member Inner Class: Value of x = " + x);
        }
    }

    // Method demonstrating Local Inner Class
    void showLocalInner() {

        // 2️⃣ Local Inner Class
        class LocalInner {

            void display() {
                System.out.println("Local Inner Class inside method");
            }
        }

        LocalInner obj = new LocalInner();
        obj.display();
    }
}

public class Program7 {

    public static void main(String[] args) {

        OuterClass outer = new OuterClass();

        // Using Member Inner Class
        OuterClass.MemberInner memberObj = outer.new MemberInner();
        memberObj.display();

        // Using Local Inner Class
        outer.showLocalInner();

        // 3️⃣ Anonymous Inner Class
        Runnable r = new Runnable() {

            public void run() {
                System.out.println("Anonymous Inner Class executed");
            }
        };

        r.run();
    }
}