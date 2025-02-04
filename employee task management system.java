import java.util.*;

class Emp {
    String name;
    int age;
    Task[] tsk;
    int tcount;

    Emp(String n, int a) {
        name = n;
        age = a;
        tsk = new Task[100];
        tcount = 0;
    }

    void addTask(Task t) {
        if (tcount < tsk.length) {
            tsk[tcount++] = t;
        } else {
            System.out.println(" Task list is full!");
        }
    }

    void showTasks() {
        for (int i = 0; i < tcount; i++) {
            tsk[i].show();
            tsk[i].display();
        }
    }
}

class Task {
    String name;
    int age;
    String type;
    String detail;
    int days, hours, minutes, seconds;

    Task(String n, int a, String t, String d, int dy, int h, int m, int s) {
        name = n;
        age = a;
        type = t;
        detail = d;
        days = dy;
        hours = h;
        minutes = m;
        seconds = s;
    }

    void show() {
        System.out.println("  \n============================");
        System.out.println("  Employee Details");
        System.out.println("  ============================");
        System.out.println("  Name: " + name);
        System.out.println("  Age: " + age);
        System.out.println("  Task Assigned: " + type);
        System.out.println("  Task Details: " + detail);
        System.out.println("  Time Limit: " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds");
    }

    void display() {

    }
}

class Tech extends Task {
    Tech(String n, int a, String d, int dy, int h, int m, int s) {
        super(n, a, "Technical", d, dy, h, m, s);
    }

    @Override
    void display() {
        System.out.println("  🔧 Engaging in technical work using " + detail + "... 🖥️");
        System.out.println("  Time Limit: " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds\n");
    }
}

class Mgr extends Task {
    Mgr(String n, int a, String d, int dy, int h, int m, int s) {
        super(n, a, "Managerial", d, dy, h, m, s);
    }

    @Override
    void display() {
        System.out.println("  📋 Managing responsibilities: " + detail + "... 🤝");
        System.out.println("  Time Limit: " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds\n");
    }
}

class Creat extends Task {
    Creat(String n, int a, String d, int dy, int h, int m, int s) {
        super(n, a, "Creative", d, dy, h, m, s);
    }

    @Override
    void display() {
        System.out.println("  🎨 Creating amazing " + detail + " content... 🎬");
        System.out.println("  Time Limit: " + days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds\n");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Emp[] employees = new Emp[100];
        int empCount = 0;

        while (true) {
            System.out.println(" \nMain Menu:");
            System.out.println(" 1. Add Employee");
            System.out.println(" 2. Display Employees and Their Tasks");
            System.out.println(" 0. Exit");
            System.out.print("   choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0) break;

            switch (ch) {
                case 1:
                    System.out.print(" Enter Employee Name: ");
                    String n = sc.nextLine();

                    int a = -1;
                    while (a < 21 || a > 58) {
                        System.out.print("   Enter Age (21-58): ");
                        if (sc.hasNextInt()) {
                            a = sc.nextInt();
                            sc.nextLine();
                            if (a < 21 || a > 58) {
                                System.out.println("  Age must be between 21 and 58.");
                            }
                        } else {
                            System.out.println("   Invalid input.");
                            sc.nextLine();
                        }
                    }

                    Emp employee = new Emp(n, a);
                    if (empCount < employees.length) {
                        employees[empCount++] = employee;
                    } else {
                        System.out.println(" Employee list is full!");
                        break;
                    }

                    while (true) {
                        System.out.println(" \nEnter Task Type:");
                        System.out.println(" 1. Technical");
                        System.out.println(" 2. Managerial");
                        System.out.println(" 3. Creative");
                        System.out.println(" 0. Finish Adding Tasks");
                        System.out.print("   choice: ");
                        int taskCh = sc.nextInt();
                        sc.nextLine();
                        if (taskCh == 0) break;

                        String t = "", d = "";
                        switch (taskCh) {
                            case 1:
                                t = "Technical";
                                break;
                            case 2:
                                t = "Managerial";
                                break;
                            case 3:
                                t = "Creative";
                                break;
                            default:
                                System.out.println("  Invalid option.");
                                continue;
                        }

                        while (d.isEmpty()) {
                            System.out.print("  Enter Task Details: ");
                            d = sc.nextLine();
                            if (d.isEmpty()) {
                                System.out.println("  Task Details cannot be empty.");
                            }
                        }

                        int dy = -1, h = -1, m = -1, s = -1;
                        
                        while (dy < 0) {
                            System.out.print("  Enter Time Limit Days: ");
                            if (sc.hasNextInt()) {
                                dy = sc.nextInt();
                                if (dy < 0) {
                                    System.out.println(" Invalid days.");
                                }
                            } else {
                                System.out.println("  Invalid input.");
                                sc.next(); 
                            }
                        }

                        // Input for hours
                        while (h < 0 || h > 23) {
                            System.out.print("  Enter Time Limit Hours (0-23): ");
                            if (sc.hasNextInt()) {
                                h = sc.nextInt();
                                if (h < 0 || h > 23) {
                                    System.out.println(" Invalid hours.");
                                }
                            } else {
                                System.out.println("  Invalid input.");
                                sc.next();
                            }
                        }

                        while (m < 0 || m > 59) {
                            System.out.print("  Enter Time Limit Minutes (0-59): ");
                            if (sc.hasNextInt()) {
                                m = sc.nextInt();
                                if (m < 0 || m > 59) {
                                    System.out.println(" Invalid minutes.");
                                }
                            } else {
                                System.out.println("  Invalid input.");
                                sc.next();
                            }
                        }
                        
                        while (s < 0 || s > 59) {
                            System.out.print("  Enter Time Limit Seconds (0-59): ");
                            if (sc.hasNextInt()) {
                                s = sc.nextInt();
                                if (s < 0 || s > 59) {
                                    System.out.println(" Invalid seconds.");
                                }
                            } else {
                                System.out.println("  Invalid input.");
                                sc.next();
                            }
                        }

                        Task task;
                        if (taskCh == 1) task = new Tech(n, a, d, dy, h, m, s);
                        else if (taskCh == 2) task = new Mgr(n, a, d, dy, h, m, s);
                        else task = new Creat(n, a, d, dy, h, m, s);
                        employee.addTask(task);
                    }
                    break;

                case 2:
                    System.out.println("  \nDisplaying all employees and their tasks:");
                    for (int i = 0; i < empCount; i++) {
                        Emp emp = employees[i];
                        System.out.println(" \nEmployee: " + emp.name + ", Age: " + emp.age);
                        emp.showTasks();
                    }
                    break;

                default:
                    System.out.println("  Invalid option. Please enter a valid option.");
            }
        }
        System.out.println("  ✅ All tasks displayed successfully! 🎉");
    }
}