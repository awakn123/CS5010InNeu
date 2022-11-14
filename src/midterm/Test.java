package midterm;

import java.util.Iterator;

public class Test {
  public static void main(String[] args) {
    Department d = new DepartmentImpl();
    // senior midterm.SDE to team 0
    d.hire(new SeniorSDE("Tom", 100, 10), 0);
    // junior midterm.SDE to team 0
    d.hire(new JuniorSDE("Jack", 100,200), 0);
    // junior midterm.SDE to team 2
    d.hire(new JuniorSDE("Elon", 200, 200000), 2);

    System.out.println("Initial state....");
    Iterator<Engineer> it = d.iterator();
    int idx = 0;
    // expected output:
    // 0 Jack $0.0
    // 1 Tom $0.0
    // 2 Elon $0.0
    while(it.hasNext()) {
      Engineer e = it.next();
      System.out.println(idx + " " + e.getName() + " $" + e.getBonus());
      idx++;
    }

    // give out bonus
    System.out.println("Giving out bonus....");
    d.giveOutBonus();

    it = d.iterator();
    idx = 0;
    // expected output:
    // 0 Jack $200.0
    // 1 Tom $200.0
    // 2 Elon $400000.0
    while(it.hasNext()) {
      Engineer e = it.next();
      System.out.println(idx + " " + e.getName() + " $" + e.getBonus());
      idx++;
    }

    System.out.println("Lay off..");
    d.layoff(300000.0);
    it = d.iterator();
    idx = 0;
    // expected output:
    // 0 Elon $400000.0
    while(it.hasNext()) {
      Engineer e = it.next();
      System.out.println(idx + " " + e.getName() + " $" + e.getBonus());
      idx++;
    }
  }
}
