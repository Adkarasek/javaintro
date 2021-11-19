package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
	//branch lambdas tutorial
    }

    private void run() {
        List<String>cars = new ArrayList<>();
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Fiat");
        cars.add("Jaguar");
        cars.add("Volkswagen");
        cars.add("Nissan");

        cars.sort((o1, o2) ->{
            String text;
            int bigger;
            if ((bigger = Integer.compare(o1.length(), o2.length())) == -1 )
                System.out.printf("comparing: %s is smaller than %s%n", o1, o2);
            else
                System.out.println("comparing: " + o1 + " is bigger than " + o2);
            return bigger;
        });

        System.out.println(cars);
        DisplayLength(cars, c->c + " " + c.length());
        DisplayFiltered(cars, c -> c.length()==6);

    }


    private void DisplayLength(List<String> list, Counter c){
        List <String> counted = new ArrayList<>();
        for (String car : list){
            String added = Count(car,c);
            counted.add(added);
            }
        System.out.println(counted);
        }

    private void DisplayFiltered(List<String>list, Filter f)
    {
        List<String>filteredList = new ArrayList<>();
        for (String car : list){
            if (LenIsEqual(car,f))
            {
               filteredList.add(car);
            }
        }
        System.out.println(filteredList);

    }
    private boolean LenIsEqual(String string, Filter filter){
        return filter.filter(string);
    }

    private String Count(String string, Counter counter){
        return counter.counted(string);
    }

}



