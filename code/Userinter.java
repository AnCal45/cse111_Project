//javac Userinter.java
// java Userinter

import java.util.Scanner;

public class Userinter{
  public static void main(String[] args){
      Scanner input = new Scanner(System.in);

      System.out.println("Welcome to our Marvel/DC character Database.");
      System.out.println("Are you a new User or the Admin?");
      System.out.println("If new User please enter 1");
      System.out.println("If Admin please enter 2");
      int whoareyou = input.nextInt();

      if (whoareyou == 1){
        System.out.println("Welcome new User what would you like to look at?");
        System.out.println("the Marvel Database press 1");
        System.out.println("The DC Database press 2");
        System.out.println("Or both at them press 3");
        int whatyouwannasee = input.nextInt();

        if (whatyouwannasee == 1){
          System.out.println("welcome to Marvel Database what do wanna see buddy");
          System.out.println("To see all characters press 1");
          System.out.println("To see a specific character press 2");
          System.out.println("To find a custom search press 3");
          int marvelsearch = input.nextInt();

          if (marvelsearch == 1){
            System.out.println("Now choose which tables you would like to see");
            System.out.println("To see all Heros press 1");
            System.out.println("To see all Villians press 2");
            System.out.println("To see all Anti-Heros press 3");
            System.out.println("To see all of them press 4");
            int marvelsearch1 = input.nextInt();

            if (marvelsearch1 == 1){
              System.out.println("now printing all the heros of marvel");
            }
            if (marvelsearch1 == 2){
              System.out.println("now printing all the Villians of marvel");
            }
            if (marvelsearch1 == 3){
              System.out.println("now printing all the Anti-Heros of marvel");
            }
            if (marvelsearch1 == 4){
              System.out.println("now printing all the characters of marvel");
            }
          }
          if (marvelsearch == 2){
            System.out.println("Now choose what alignment your character belongs too");
            System.out.println("To see all Heros press 1");
            System.out.println("To see all Villians press 2");
            System.out.println("To see all Anti-Heros press 3");
            int marvelsearch2 = input.nextInt();

            if (marvelsearch2 == 1){
              System.out.println("Now that you know your charater is a Hero how would you to find them");
              System.out.println("If you want to see by Name press 1");
              System.out.println("If you want to see by Race press 2");
              System.out.println("If you want to see by Gender press 3");
              System.out.println("If you want to see by What Teams they are part of press 4");
              int marvelherosearch = input.nextInt();
              if (marvelherosearch == 1){
                System.out.println("Please type the Name of the Hero you wanna see buddy");
                String marvelHeroname = input.nextLine();
              }
              if (marvelherosearch == 2){
                System.out.println("please select one of the following races that you want to see the heros from");
                System.out.println("To see the following heros that are Human press 1");
                System.out.println("To see the following heros that are Mutant press 2");
                System.out.println("To see the following heros that are Inhuman press 3");
                System.out.println("To see the following heros that are Asgardian press 4");
                System.out.println("To see the following heros that are Human-Kree press 5");
                System.out.println("To see the following heros that are Human Mutate press 6");
                System.out.println("To see the following heros that are Zenn-Lavian press 7");
                System.out.println("To see the following heros that are Alien press 8");
                System.out.println("To see the following heros that are Flora colossus press 9");
                System.out.println("To see the following heros that are os + old armor press 10");
                int marvelherorace = input.nextInt();

                if (marvelherorace == 1){
                  System.out.println("Now printing the heros that are Human");
                }
                if (marvelherorace == 2){
                  System.out.println("Now printing the heros that are Mutant");
                }
                if (marvelherorace == 3){
                  System.out.println("Now printing the heros that are Inhuman");
                }
                if (marvelherorace == 4){
                  System.out.println("Now printing the heros that are Asgardian");
                }
                if (marvelherorace == 5){
                  System.out.println("Now printing the heros that are Human-Kree");
                }
                if (marvelherorace == 6){
                  System.out.println("Now printing the heros that are Human Mutate");
                }
                if (marvelherorace == 7){
                  System.out.println("Now printing the heros that are Zenn-Lavian");
                }
                if (marvelherorace == 8){
                  System.out.println("Now printing the heros that are Alien");
                }
                if (marvelherorace == 9){
                  System.out.println("Now printing the heros that are Flora colossus");
                }
                if (marvelherorace == 10){
                  System.out.println("Now printing the heros that are os + old armor");
                }


              }
              if (marvelherosearch == 3){
                System.out.println("Here is the list of all the genders in Marvel heros choose which you like to see");
                System.out.println("To see all of Male of the Marvel hearos press 1");
                System.out.println("To see all of Female of the Marvel hearos press 2");
                int marvelgendersearch = input.nextInt();

                if (marvelgendersearch == 1){
                  System.out.println("Now printing all of Males of the Marvel heros tables");

                }
                if (marvelgendersearch == 2){
                  System.out.println("Now printing all of Female of the Marvel heros tables");

                }
              }
              if (marvelherosearch == 4){
                  System.out.println("Here is the list of all the teams in Marvel heros choose which you like to see");
                  System.out.println(" to see the members of Avengers please press 1");
                  System.out.println(" to see the members of S.H.I.E.L.D. please press 2");
                  System.out.println(" to see the members of Guardians of the Galaxy please press 3");
                  System.out.println(" to see the members of Fantastic 4 please press 4");
                  System.out.println(" to see the members of Defenders please press 5");
                  System.out.println(" to see the members of Mighty Avengers please press 6");
                  System.out.println(" to see the members of New Avengers please press 7");
                  System.out.println(" to see the members of Illuminati please press 8");
                  System.out.println(" to see the members of Weapon X please press 9");
                  System.out.println(" to see the members of X-men please press 10");
                  System.out.println(" to see the members of NASA please press 11");
                  System.out.println(" to see the members of Stark Industries please press 12");
                  System.out.println(" to see the members of KGB please press 13");
                  System.out.println(" to see the members of Lady Liberators please press 14");
                  System.out.println(" to see the members of Acts of Vengeance please press 15");
                  System.out.println(" to see the members of Heralds of Galactus please press 16");
                  System.out.println(" to see the members of Four Horsemen please press 17");
                  System.out.println(" to see the members of Dark Avengers please press 18");
                  System.out.println(" to see the members of Young Avengers please press 19");
                  int marvelheroteamsearch = input.nextInt();

                  if (marvelheroteamsearch == 1){
                    System.out.println("now printing all of the members of Avengers");
                }
                  if (marvelheroteamsearch == 2){
                    System.out.println ("now printing all of the members of S.H.I.E.L.D.");
                }
                  if (marvelheroteamsearch == 3){
                    System.out.println ("now printing all of the members of Guardians of the Galaxy");
                }
                  if (marvelheroteamsearch == 4){
                    System.out.println ("now printing all of the members of Fantastic 4");
                }
                  if (marvelheroteamsearch == 5){
                    System.out.println ("now printing all of the members of Defenders");
                }
                  if (marvelheroteamsearch == 6){
                    System.out.println ("now printing all of the members of Mighty Avengers");
                }
                  if (marvelheroteamsearch == 7){
                    System.out.println ("now printing all of the members of New Avengers");
                }
                  if (marvelheroteamsearch == 8){
                    System.out.println ("now printing all of the members of Illuminati");
                }
                  if (marvelheroteamsearch == 9){
                    System.out.println ("now printing all of the members of Weapon X");
                }
                  if (marvelheroteamsearch == 10){
                    System.out.println ("now printing all of the members of X-men");
                }
                  if (marvelheroteamsearch == 11){
                    System.out.println ("now printing all of the members of NASA");
                }
                  if (marvelheroteamsearch == 12){
                    System.out.println ("now printing all of the members of Stark Industries");
                }
                  if (marvelheroteamsearch == 13){
                    System.out.println ("now printing all of the members of KGB");
                }
                  if (marvelheroteamsearch == 14){
                    System.out.println ("now printing all of the members of Lady Liberators");
                }
                  if (marvelheroteamsearch == 15){
                    System.out.println ("now printing all of the members of Acts of Vengeance");
                }
                  if (marvelheroteamsearch == 16){
                    System.out.println ("now printing all of the members of Heralds of Galactus");
                }
                  if (marvelheroteamsearch == 17){
                    System.out.println ("now printing all of the members of Four Horsemen");
                }
                  if (marvelheroteamsearch == 18){
                    System.out.println ("now printing all of the members of Dark Avengers");
                }
                  if (marvelheroteamsearch == 19){
                    System.out.println ("now printing all of the members of Young Avengers");
                }
              }
            }
            if (marvelsearch2 == 2){
              System.out.println("Now that you know your charater is a Villian how would you to find them");
              System.out.println("If you want to see by Name press 1");
              System.out.println("If you want to see by Race press 2");
              System.out.println("If you want to see by Gender press 3");
              System.out.println("If you want to see by What Teams they are part of press 4");
              int marvelvilliansearch = input.nextInt();

              if (marvelvilliansearch == 1){
                System.out.println("Please type the Name of the villian you wanna see buddy");
                String marvelvillianame = input.nextLine();
              }
              if (marvelvilliansearch == 2){
                System.out.println("please pick one of the following races to see");
                System.out.print("to see the following Taa-an please select 1");
                System.out.print("to see the following Jotunn-God please select 2");
                System.out.print("to see the following Synthezoid please select 3");
                System.out.print("to see the following Human please select 4");
                System.out.print("to see the following Eternals-Deviant Hybrid please select 5");
                System.out.print("to see the following Mutant please select 6");
                System.out.print("to see the following Human Mutate please select 7");
                System.out.print("to see the following Symbiote please select 8");
                System.out.print("to see the following Sentinel please select 9");
                System.out.print("to see the following Arthrosian please select 10");
                System.out.print("to see the following Human (empowered) please select 11");
                System.out.print("to see the following Asgardian please select 12");
                int marvelvillianracesearch = input.nextInt();

                  if (marvelvillianracesearch == 1){
                  System.out.println("now printing all the villians that are Taa-an ");

                }
                  if (marvelvillianracesearch == 2){
                  System.out.println("now printing all the villians that are Jotunn-God ");

                }
                  if (marvelvillianracesearch == 3){
                  System.out.println("now printing all the villians that are Synthezoid ");

                }
                  if (marvelvillianracesearch == 4){
                  System.out.println("now printing all the villians that are Human ");

                }
                  if (marvelvillianracesearch == 5){
                  System.out.println("now printing all the villians that are Eternals-Deviant Hybrid ");

                }
                  if (marvelvillianracesearch == 6){
                  System.out.println("now printing all the villians that are Mutant ");

                }
                  if (marvelvillianracesearch == 7){
                  System.out.println("now printing all the villians that are Human Mutate ");

                }
                  if (marvelvillianracesearch == 8){
                  System.out.println("now printing all the villians that are Symbiote ");

                }
                  if (marvelvillianracesearch == 9){
                  System.out.println("now printing all the villians that are Sentinel ");

                }
                  if (marvelvillianracesearch == 10){
                  System.out.println("now printing all the villians that are Arthrosian ");

                }
                  if (marvelvillianracesearch == 11){
                  System.out.println("now printing all the villians that are Human (empowered) ");

                }
                  if (marvelvillianracesearch == 12){
                  System.out.println("now printing all the villians that are Asgardian ");

                }
              }
              if (marvelvilliansearch == 3){
                System.out.println("to see the following villian(s) that are Male press 1");
                System.out.println("to see the following villian(s) that are Female press 2");
                System.out.println("to see the following villian(s) that are Binary press 3");
                int marvelvilliangendersearch = input.nextInt();

                if (marvelvilliangendersearch == 1){
                  System.out.println("Now printing all of Males of the Marvel villian tables");

                }
                if (marvelvilliangendersearch == 2){
                  System.out.println("Now printing all of Female of the Marvel villian tables");

                }
                if (marvelvilliangendersearch == 3){
                  System.out.println("Now printing all of Binary of the Marvel villian tables");

                }


              }
              if (marvelvilliansearch == 4){
                System.out.println("Please select which Team of villians would you like to see");
                System.out.println(" to see the villians that belong to Avengers please select 1");
                System.out.println(" to see the villians that belong to X-men please select 2");
                System.out.println(" to see the villians that belong to Acts of Vengeance please select 3");
                System.out.println(" to see the villians that belong to Young Avengers please select 4");
                System.out.println(" to see the villians that belong to Cabal please select 5");
                System.out.println(" to see the villians that belong to Masters of Evil please select 6");
                System.out.println(" to see the villians that belong to Ultron Sentries please select 7");
                System.out.println(" to see the villians that belong to HYDRA please select 8");
                System.out.println(" to see the villians that belong to Nazi Germany (SS-Oberführer) please select 9");
                System.out.println(" to see the villians that belong to Black Order please select 10");
                System.out.println(" to see the villians that belong to Infinity Watch please select 11");
                System.out.println(" to see the villians that belong to Brotherhood of Mutants please select 12");
                System.out.println(" to see the villians that belong to Order of the Goblin please select 13");
                System.out.println(" to see the villians that belong to Dark Avengers please select 14");
                System.out.println(" to see the villians that belong to S.H.I.E.L.D. please select 15");
                System.out.println(" to see the villians that belong to Guardians of the Galaxy please select 16");
                System.out.println(" to see the villians that belong to KGB please select 17");
                System.out.println(" to see the villians that belong to AIM please select 18");
                System.out.println(" to see the villians that belong to Lady Liberators please select 19");
                System.out.println(" to see the villians that belong to Sisterhood of Mutants please select 20");
                System.out.println(" to see the villians that belong to Annihilation Wave please select 21");
                System.out.println(" to see the villians that belong to Council of Kangs please select 22");
                System.out.println(" to see the villians that belong to Weapon X please select 23");
                System.out.println(" to see the villians that belong to The Hand please select 24");
                System.out.println(" to see the villians that belong to Emissaries of Evil please select 25");
                System.out.println(" to see the villians that belong to Four Horsemen please select 26");
                System.out.println(" to see the villians that belong to Dark Riders please select 27");
                System.out.println(" to see the villians that belong to Alliance of Evil please select 28");
                System.out.println(" to see the villians that belong to Sorcerers Supreme please select 29");
                System.out.println(" to see the villians that belong to Stark Industries please select 30");
                System.out.println(" to see the villians that belong to The Chessmen please select 31");
                System.out.println(" to see the villians that belong to Death Gods please select 32");
                System.out.println(" to see the villians that belong to Hell-Lords please select 33");
                int marvelvillianteamsearch = input.nextInt();

                if (marvelvillianteamsearch == 1){
                System.out.println(" now showing the villian members of Avengers");

                }
                if (marvelvillianteamsearch == 2){
                System.out.println(" now showing the villian members of X-men");

                }
                if (marvelvillianteamsearch == 3){
                System.out.println(" now showing the villian members of Acts of Vengeance");

                }
                if (marvelvillianteamsearch == 4){
                System.out.println(" now showing the villian members of Young Avengers");

                }
                if (marvelvillianteamsearch == 5){
                System.out.println(" now showing the villian members of Cabal");

                }
                if (marvelvillianteamsearch == 6){
                System.out.println(" now showing the villian members of Masters of Evil");

                }
                if (marvelvillianteamsearch == 7){
                System.out.println(" now showing the villian members of Ultron Sentries");

                }
                if (marvelvillianteamsearch == 8){
                System.out.println(" now showing the villian members of HYDRA");

                }
                if (marvelvillianteamsearch == 9){
                System.out.println(" now showing the villian members of Nazi Germany (SS-Oberführer)");

                }
                if (marvelvillianteamsearch == 10){
                System.out.println(" now showing the villian members of Black Order");

                }
                if (marvelvillianteamsearch == 11){
                System.out.println(" now showing the villian members of Infinity Watch");

                }
                if (marvelvillianteamsearch == 12){
                System.out.println(" now showing the villian members of Brotherhood of Mutants");

                }
                if (marvelvillianteamsearch == 13){
                System.out.println(" now showing the villian members of Order of the Goblin");

                }
                if (marvelvillianteamsearch == 14){
                System.out.println(" now showing the villian members of Dark Avengers");

                }
                if (marvelvillianteamsearch == 15){
                System.out.println(" now showing the villian members of S.H.I.E.L.D.");

                }
                if (marvelvillianteamsearch == 16){
                System.out.println(" now showing the villian members of Guardians of the Galaxy");

                }
                if (marvelvillianteamsearch == 17){
                System.out.println(" now showing the villian members of KGB");

                }
                if (marvelvillianteamsearch == 18){
                System.out.println(" now showing the villian members of AIM");

                }
                if (marvelvillianteamsearch == 19){
                System.out.println(" now showing the villian members of Lady Liberators");

                }
                if (marvelvillianteamsearch == 20){
                System.out.println(" now showing the villian members of Sisterhood of Mutants");

                }
                if (marvelvillianteamsearch == 21){
                System.out.println(" now showing the villian members of Annihilation Wave");

                }
                if (marvelvillianteamsearch == 22){
                System.out.println(" now showing the villian members of Council of Kangs");

                }
                if (marvelvillianteamsearch == 23){
                System.out.println(" now showing the villian members of Weapon X");

                }
                if (marvelvillianteamsearch == 24){
                System.out.println(" now showing the villian members of The Hand");

                }
                if (marvelvillianteamsearch == 25){
                System.out.println(" now showing the villian members of Emissaries of Evil");

                }
                if (marvelvillianteamsearch == 26){
                System.out.println(" now showing the villian members of Four Horsemen");

                }
                if (marvelvillianteamsearch == 27){
                System.out.println(" now showing the villian members of Dark Riders");

                }
                if (marvelvillianteamsearch == 28){
                System.out.println(" now showing the villian members of Alliance of Evil");

                }
                if (marvelvillianteamsearch == 29){
                System.out.println(" now showing the villian members of Sorcerers Supreme");

                }
                if (marvelvillianteamsearch == 30){
                System.out.println(" now showing the villian members of Stark Industries");

                }
                if (marvelvillianteamsearch == 31){
                System.out.println(" now showing the villian members of The Chessmen");

                }
                if (marvelvillianteamsearch == 32){
                System.out.println(" now showing the villian members of Death Gods");

                }
                if (marvelvillianteamsearch == 33){
                System.out.println(" now showing the villian members of Hell-Lords");

                }

              }
            }
            if (marvelsearch2 == 3){
              System.out.println("Now that you know your charater is a Anti-Hero how would you to find them");
              System.out.println("If you want to see by Name press 1");
              System.out.println("If you want to see by Race press 2");
              System.out.println("If you want to see by Gender press 3");
              System.out.println("If you want to see by What Teams they are part of press 4");
            }
          }
          if (marvelsearch == 3){
            System.out.println("now tell me traveler watcha looking for");
          }


        }
        if (whatyouwannasee == 2){
          System.out.println("welcome to DC Database what do wanna see buddy");
          System.out.println("To see all characters press 1");
          System.out.println("To see a specific character press 2");
          System.out.println("To find a custom search press 3");
          int dcsearch = input.nextInt();

        if (dcsearch == 1){
          System.out.println("Now choose which tables you would like to see");
          System.out.println("To see all Heros press 1");
          System.out.println("To see all Villians press 2");
          System.out.println("To see all Anti-Heros press 3");
          System.out.println("To see all of them press 4");
          int dcsearch1 = input.nextInt();

          if (dcsearch1 == 1){
            System.out.println("now printing all the heros of DC");
          }
          if (dcsearch1 == 2){
            System.out.println("now printing all the Villians of DC");
          }
          if (dcsearch1 == 3){
            System.out.println("now printing all the Anti-Heros of DC");
          }
          if (dcsearch1 == 4){
            System.out.println("now printing all the characters of DC");
          }
        }
        if (dcsearch == 2){
          System.out.println("Now choose what alignment your character belongs too");
          System.out.println("If your charater is a Hero press 1");
          System.out.println("If your charater is a Villian press 2");
          System.out.println("If your charater is a Anti-Hero press 3");
          int dcsearch2 = input.nextInt();

          if (dcsearch2 == 1){
            System.out.println("Now that you know your charater is a Hero how would you to find them");
            System.out.println("If you want to see by Name press 1");
            System.out.println("If you want to see by Race press 2");
            System.out.println("If you want to see by Gender press 3");
            System.out.println("If you want to see by What Teams they are part of press 4");
            int dcherosearch = input.nextInt();
            if (dcherosearch == 1){
              System.out.println("Please type the Name of the Hero you wanna see buddy");
              String Heroname = input.nextLine();
            }
            if (dcherosearch == 2){
              System.out.println("please select one of the following races that you want to see the heros from");
              System.out.println("If the certain race is Human press 1");
              System.out.println("If the certain race is Cyborg press 2");
              System.out.println("If the certain race is Human-Atlantean Hybrid press 3");
              System.out.println("If the certain race is Tamaranean press 4");
              System.out.println("If the certain race is Meta-human press 5");
              System.out.println("If the certain race is Kryptonian press 6");
              System.out.println("If the certain race is Green Martian press 7");
              System.out.println("If the certain race is Amazonian-Olympian Goddess press 8");
              System.out.println("If the certain race is Homo magi press 9");
              System.out.println("If the certain race is Cambion press 10");
              System.out.println("If the certain race is White Martian/Green Martian press 11");
              int whatrace = input.nextInt();
              if (whatrace == 1){
                System.out.println("Now printing the Hero(s) of the following race Human");

              }
              if (whatrace == 2){
                System.out.println("Now printing the Hero(s) of the following race Cyborg");

              }
              if (whatrace == 3){
                System.out.println("Now printing the Hero(s) of the following race Human-Atlantean Hybrid");

              }
              if (whatrace == 4){
                System.out.println("Now printing the Hero(s) of the following race Tamaranean");

              }
              if (whatrace == 5){
                System.out.println("Now printing the Hero(s) of the following race Meta-human");

              }
              if (whatrace == 6){
                System.out.println("Now printing the Hero(s) of the following race Kryptonian");

              }
              if (whatrace == 7){
                System.out.println("Now printing the Hero(s) of the following race Green Martian");

              }
              if (whatrace == 8){
                System.out.println("Now printing the Hero(s) of the following race Amazonian-Olympian Goddess");

              }
              if (whatrace == 9){
                System.out.println("Now printing the Hero(s) of the following race Homo magi");

              }
              if (whatrace == 10){
                System.out.println("Now printing the Hero(s) of the following race Cambion");

              }
              if (whatrace == 11){
                System.out.println("Now printing the Hero(s) of the following race White Martian/Green Martian");

              }

            }
            if (dcherosearch == 3){
              System.out.println("Here is the list of all the genders in DC heros choose which you like to see");
              System.out.println("To see all of Male of the DC hearos press 1");
              System.out.println("To see all of Female of the DC hearos press 2");
              int dcgendersearch = input.nextInt();

              if (dcgendersearch == 1){
                System.out.println("Now printing all of Males of the DC heros tables");

              }
              if (dcgendersearch == 2){
                System.out.println("Now printing all of Female of the DC heros tables");

              }
            }
            if (dcherosearch == 4){
              System.out.println("Here is the list of all the teams in DC heros choose which you like to see");
              System.out.println("if you want to see the heros that belong to Justice League please press 1");
              System.out.println("if you want to see the heros that belong to Teen Titans please press 2");
              System.out.println("if you want to see the heros that belong to Batman Family please press 3");
              System.out.println("if you want to see the heros that belong to Young Justice please press 4");
              System.out.println("if you want to see the heros that belong to Doom Patrol please press 5");
              System.out.println("if you want to see the heros that belong to Birds of prey please press 6");
              System.out.println("if you want to see the heros that belong to Green Lantern Corps please press 7");
              System.out.println("if you want to see the heros that belong to Justice League Dark please press 8");
              System.out.println("if you want to see the heros that belong to Suicide Squad please press 9");
              int dcheroteamsearch = input.nextInt();

              if ( dcheroteamsearch == 1){
                System.out.println ("Now printing the heros that belong to the Justice League");
              }
              if ( dcheroteamsearch == 2){
                System.out.println ("Now printing the heros that belong to the Teen Titans");
              }
              if ( dcheroteamsearch == 3){
                System.out.println ("Now printing the heros that belong to the Batman Family");
              }
              if ( dcheroteamsearch == 4){
                System.out.println ("Now printing the heros that belong to the Young Justice");
              }
              if ( dcheroteamsearch == 5){
                System.out.println ("Now printing the heros that belong to the Doom Patrol");
              }
              if ( dcheroteamsearch == 6){
                System.out.println ("Now printing the heros that belong to the Birds of prey");
              }
              if ( dcheroteamsearch == 7){
                System.out.println ("Now printing the heros that belong to the Green Lantern Corps");
              }
              if ( dcheroteamsearch == 8){
                System.out.println ("Now printing the heros that belong to the Justice League Dark");
              }
              if ( dcheroteamsearch == 9){
                System.out.println ("Now printing the heros that belong to the Suicide Squad please");
              }
            }
          }
          if (dcsearch2 == 2){
            System.out.println("Now that you know your charater is a Villian how would you to find them");
            System.out.println("If you want to see by Name press 1");
            System.out.println("If you want to see by Race press 2");
            System.out.println("If you want to see by Gender press 3");
            System.out.println("If you want to see by What Teams they are part of press 4");
            int dcvilliansearch = input.nextInt();

            if (dcvilliansearch == 1){
              System.out.println("Please type the Name of the villian you wanna see buddy");
              String villianame = input.nextLine();
            }
            if (dcvilliansearch == 2){
              System.out.println("if the following villian's race is New God press 1");
              System.out.println("if the following villian's race is Korugarian press 2");
              System.out.println("if the following villian's race is Mutant press 3");
              System.out.println("if the following villian's race is Coluan press 4");
              System.out.println("if the following villian's race is Human press 5");
              System.out.println("if the following villian's race is Prehistoric Kryptonian press 6");
              System.out.println("if the following villian's race is Human Mutate press 7");
              System.out.println("if the following villian's race is Mighty Human press 8");
              System.out.println("if the following villian's race is Meta-Human press 9");
              System.out.println("if the following villian's race is Ape press 10");
              System.out.println("if the following villian's race is Kryptonian press 11");
              System.out.println("if the following villian's race is Demon press 12");
              int dcvillianracesearch = input.nextInt();

              if (dcvillianracesearch == 1){
                System.out.println("Now printing the following Villians that are the folloing race New God");

              }
              if (dcvillianracesearch == 2){
                System.out.println("Now printing the following Villians that are the folloing race Korugarian");

              }
              if (dcvillianracesearch == 3){
                System.out.println("Now printing the following Villians that are the folloing race Mutant");

              }
              if (dcvillianracesearch == 4){
                System.out.println("Now printing the following Villians that are the folloing race Coluan");

              }
              if (dcvillianracesearch == 5){
                System.out.println("Now printing the following Villians that are the folloing race Human");

              }
              if (dcvillianracesearch == 6){
                System.out.println("Now printing the following Villians that are the folloing race Prehistoric Kryptonian");

              }
              if (dcvillianracesearch == 7){
                System.out.println("Now printing the following Villians that are the folloing race Human Mutate");

              }
              if (dcvillianracesearch == 8){
                System.out.println("Now printing the following Villians that are the folloing race Mighty Human");

              }
              if (dcvillianracesearch == 9){
                System.out.println("Now printing the following Villians that are the folloing race Meta-Human");

              }
              if (dcvillianracesearch == 10){
                System.out.println("Now printing the following Villians that are the folloing race Ape");

              }
              if (dcvillianracesearch == 11){
                System.out.println("Now printing the following Villians that are the folloing race Kryptonian");

              }
              if (dcvillianracesearch == 12){
                System.out.println("Now printing the following Villians that are the folloing race Demon");

              }
            }
            if (dcvilliansearch == 3){
              System.out.println("to see the following villian(s) that are Male press 1");
              System.out.println("to see the following villian(s) that are Female press 2");
              System.out.println("to see the following villian(s) that are Binary press 3");
              int dcvilliangendersearch = input.nextInt();

              if (dcvilliangendersearch == 1){
                System.out.println("Now printing the following character(s) that are Male");
              }

              if (dcvilliangendersearch == 2){
                System.out.println("Now printing the following character(s) that are Female");
              }

              if (dcvilliangendersearch == 3){
                System.out.println("Now printing the following character(s) that are Binary");
              }

            }
            if (dcvilliansearch == 4){
              System.out.println("Please select which Team of villians would you like to see");
              System.out.println(" to see the members of Darkseid's Elite please press 1");
              System.out.println(" to see the members of Legion of Doom please press 2");
              System.out.println(" to see the members of Secret Society of Super Villains please press 3");
              System.out.println(" to see the members of Sinestro Corps please press 4");
              System.out.println(" to see the members of Injustice League please press 5");
              System.out.println(" to see the members of Anti-Justice League please press 6");
              System.out.println(" to see the members of Suicide Squad please press 7");
              System.out.println(" to see the members of League of Assassins please press 8");
              System.out.println(" to see the members of H.I.V.E. please press 9");
              System.out.println(" to see the members of Kryptonian Military Guild please press 10");
              System.out.println(" to see the members of Council of Immortals please press 11");
              System.out.println(" to see the members of Church of Blood please press 12");
              System.out.println(" to see the members of NASA please press 13");
              int dcvillianteamsearch = input.nextInt();

              if (dcvillianteamsearch == 1){
                System.out.println("Now printing all of the characters that belong to Darkseid's Elite");
              }
              if (dcvillianteamsearch == 2){
                System.out.println("Now printing all of the characters that belong to Legion of Doom");
              }
              if (dcvillianteamsearch == 3){
                System.out.println("Now printing all of the characters that belong to Secret Society of Super Villains");
              }
              if (dcvillianteamsearch == 4){
                System.out.println("Now printing all of the characters that belong to Sinestro Corps");
              }
              if (dcvillianteamsearch == 5){
                System.out.println("Now printing all of the characters that belong to Injustice League");
              }
              if (dcvillianteamsearch == 6){
                System.out.println("Now printing all of the characters that belong to Anti-Justice League");
              }
              if (dcvillianteamsearch == 7){
                System.out.println("Now printing all of the characters that belong to Suicide Squad");
              }
              if (dcvillianteamsearch == 8){
                System.out.println("Now printing all of the characters that belong to League of Assassins");
              }
              if (dcvillianteamsearch == 9){
                System.out.println("Now printing all of the characters that belong to H.I.V.E.");
              }
              if (dcvillianteamsearch == 10){
                System.out.println("Now printing all of the characters that belong to Kryptonian Military Guild");
              }
              if (dcvillianteamsearch == 11){
                System.out.println("Now printing all of the characters that belong to Council of Immortals");
              }
              if (dcvillianteamsearch == 12){
                System.out.println("Now printing all of the characters that belong to Church of Blood");
              }
              if (dcvillianteamsearch == 13){
                System.out.println("Now printing all of the characters that belong to NASA");
              }

            }
          }
          if (dcsearch2 == 3){
            System.out.println("Now that you know your charater is a Anti-Hero how would you to find them");
            System.out.println("If you want to see by Name press 1");
            System.out.println("If you want to see by Race press 2");
            System.out.println("If you want to see by Gender press 3");
            System.out.println("If you want to see by What Teams they are part of press 4");
          }
        }
        if (dcsearch == 3){
          System.out.println("now tell me traveler watcha looking for");
        }
      }

        if (whatyouwannasee == 3){
          System.out.println("welcome to Marvel & DC Database what do wanna see buddy");
          System.out.println("To see all characters press 1");
          System.out.println("To see a specific character press 2");
          System.out.println("To find a custom search press 3");
          int marveldcsearch = input.nextInt();
        }




    }


      if (whoareyou == 2){
        System.out.println("Welcome back Master plwes put pwassword plws");
        int psswrd = input.nextInt();
        int entry;

        if (psswrd == 1111){
          System.out.println("Correct password welcome back");
          entry = 1;

        }
        else{
          System.out.println("Incorrect password bzz bzz");
          entry = 0;
        }

        if(entry == 1){
          System.out.println("welcom admin what would u like to do today");
          System.out.println("if you would like to INSERT the Database press 1");
          System.out.println("if you would like to UPDATE the Database press 2");
          System.out.println("if you would like to DELETE the Database press 3");
          System.out.println("if you would like to VEIW the Database press 4");
          int whatchawannado = input.nextInt();

          if (whatchawannado == 1){
            System.out.println("ah I see you would like to INSERT now which table would you like to edit ");
            System.out.println("if you would like to edit NormalIdentity table press 1");
            System.out.println("if you would like to edit Superhero table press 2");
            System.out.println("if you would like to edit Antihero table press 3");
            System.out.println("if you would like to edit Villain table press 4");
            System.out.println("if you would like to edit Team table press 5");
            System.out.println("if you would like to edit Version table press 6");
            System.out.println("if you would like to edit Superpower table press 7");
            System.out.println("if you would like to edit Archenemy table press 8");
            System.out.println("if you would like to edit Race table press 9");
            System.out.println("if you would like to edit Dimension table press 10");
            int whattablebuddy1 = input.nextInt();

            if (whattablebuddy1 == 1){
              System.out.println("I see you want to insert into NormalIdentity please input the following values");
              System.out.println("please put the ni_ID int");
              int normalID = input.nextInt();
              System.out.println("please put the ni_persoinID int");
              int normalpersonID = input.nextInt();
              System.out.println("please put the ni_name string");
              String normalname = input.nextLine();
              System.out.println("please put the ni_gender string");
              String normalgender = input.nextLine();
              System.out.println("please put the ni_dob string");
              String normadob = input.nextLine();
            }
            if (whattablebuddy1 == 2){
              System.out.println("I see you want to insert into Superhero please input the following values");
              System.out.println("please put the sh_ID int");
              int shID = input.nextInt();
              System.out.println("please put the sh_SuperheroID int");
              int SuperheroID = input.nextInt();
              System.out.println("please put the sh_Name string");
              String shname = input.nextLine();
              System.out.println("please put the sh_SuperpowerID Int");
              int shSuperpowerID = input.nextInt();
              System.out.println("please put the sh_Description string");
              String shDescription = input.nextLine();
            }
            if (whattablebuddy1 == 3){
              System.out.println("I see you want to insert into Antihero please input the following values");
              System.out.println("please put the ah_ID int");
              int ahID = input.nextInt();
              System.out.println("please put the ah_AntiheroID int");
              int AntiheroID = input.nextInt();
              System.out.println("please put the ah_Name string");
              String ahname = input.nextLine();
              System.out.println("please put the ah_SuperpowerID Int");
              int ahSuperpowerID = input.nextInt();
              System.out.println("please put the ah_Description string");
              String ahDescription = input.nextLine();
            }
            if (whattablebuddy1 == 4){
              System.out.println("I see you want to insert into Villain please input the following values");
              System.out.println("please put the v_ID int");
              int vID = input.nextInt();
              System.out.println("please put the v_VillianID int");
              int villianID = input.nextInt();
              System.out.println("please put the v_Name string");
              String  vname = input.nextLine();
              System.out.println("please put the v_SuperpowerID Int");
              int vSuperpowerID = input.nextInt();
              System.out.println("please put the v_Description string");
              String vDescription = input.nextLine();
            }
            if (whattablebuddy1 == 5){
              System.out.println("I see you want to insert into Team please input the following values");
              System.out.println("please put the t_superhetroID int");
              int tshID = input.nextInt();
              System.out.println("please put the t_VillianID int");
              int tvID = input.nextInt();
              System.out.println("please put the t_antiheroID int");
              int tahID = input.nextInt();
              System.out.println("please put the t_Name string");
              String  vname = input.nextLine();
              System.out.println("please put the t_teamID Int");
              int vSuperpowerID = input.nextInt();

            }
            if (whattablebuddy1 == 6){
              System.out.println("I see you want to insert into Version please input the following values");
              System.out.println("please put the ver_superhetroID int");
              int vershID = input.nextInt();
              System.out.println("please put the ver_VillianID int");
              int vervID = input.nextInt();
              System.out.println("please put the ver_antiheroID int");
              int verahID = input.nextInt();
              System.out.println("please put the ver_Name string");
              String vername = input.nextLine();
              System.out.println("please put the ver_ID Int");
              int verID = input.nextInt();
            }
            if (whattablebuddy1 == 7){
              System.out.println("I see you want to insert into Superpower please input the following values");
              System.out.println("please put the sp_ID int");
              int spID = input.nextInt();
              System.out.println("please put the sp_PowerID int");
              int powerID = input.nextInt();
              System.out.println("please put the t_Name string");
              String  vname = input.nextLine();
              System.out.println("please put the sp_Description string");
              String  spdescrip = input.nextLine();

            }
            if (whattablebuddy1 == 8){
              System.out.println("I see you want to insert into Archenemy please input the following values");
              System.out.println("please put the ae_superhetroID int");
              int aeshID = input.nextInt();
              System.out.println("please put the ae_VillianID int");
              int aevID = input.nextInt();
              System.out.println("please put the ae_ID int");
              int aeID = input.nextInt();
            }
            if (whattablebuddy1 == 9){
              System.out.println("I see you want to insert into Race please input the following values");
              System.out.println("please put the r_ID int");
              int rID = input.nextInt();
              System.out.println("please put the r_Name string");
              String rname = input.nextLine();
            }
            if (whattablebuddy1 == 10){
              System.out.println("I see you want to insert into Dimension please input the following values");
              System.out.println("please put the d_dimensionID int");
              int dID = input.nextInt();
              System.out.println("please put the ver_Name string");
              String dname = input.nextLine();
              System.out.println("please put the d_verionID Int");
              int dverID = input.nextInt();

            }

          }
          if (whatchawannado == 2){
            System.out.println("ah I see you would like to UPDATE now which table would you like to edit ");
            System.out.println("if you would like to edit NormalIdentity table press 1");
            System.out.println("if you would like to edit Superhero table press 2");
            System.out.println("if you would like to edit Antihero table press 3");
            System.out.println("if you would like to edit Villain table press 4");
            System.out.println("if you would like to edit Team table press 5");
            System.out.println("if you would like to edit Version table press 6");
            System.out.println("if you would like to edit Superpower table press 7");
            System.out.println("if you would like to edit Archenemy table press 8");
            System.out.println("if you would like to edit Race table press 9");
            System.out.println("if you would like to edit Dimension table press 10");
            int whattablebuddy2 = input.nextInt();

            if (whattablebuddy2 == 1){
              System.out.println("so you wanted to UPDATE  the NormalIdentity table please input new values and where they would replace them");
              System.our.println("press 1 if you are updating a Int value, press 2 for a string value");
              int normalidentitupdate = input.nextInt();
              if (normalidentitupdate == 1){
                System.out.println("now put in the new int value that will replace the old");
                int newnrmalid = input.nextInt();
              }
              if (normalidentitupdate == 2){
                System.out.println("now put in the new string value that will replace the old");
                String newnrmalidln = input.nextLine();
              }
            }

          }
          if (whatchawannado == 3){
            System.out.println("ah I see you would like to DELETE now which table would you like to edit ");
            System.out.println("if you would like to edit NormalIdentity table press 1");
            System.out.println("if you would like to edit Superhero table press 2");
            System.out.println("if you would like to edit Antihero table press 3");
            System.out.println("if you would like to edit Villain table press 4");
            System.out.println("if you would like to edit Team table press 5");
            System.out.println("if you would like to edit Version table press 6");
            System.out.println("if you would like to edit Superpower table press 7");
            System.out.println("if you would like to edit Archenemy table press 8");
            System.out.println("if you would like to edit Race table press 9");
            System.out.println("if you would like to edit Dimension table press 10");
            int whattablebuddy3 = input.nextInt();

            if(whattablebuddy3 == 1){
              System.out.println("so yoou want to delete from the NormalIdentity");
              System.out.println("press 1 for int conditon or 2 for a string");
              int deletenormid = input.nextInt();
              if (deletenormid == 1){
                System.out.println("now put in the new int value that will replace the old");
                int newnrmalid = input.nextInt();
              }
              if (deletenormid == 2){
                System.out.println("now put in the new string value that will replace the old");
                String newnrmalidln = input.nextLine();
            }

          }
          if (whatchawannado == 4){
            System.out.println("ah I see you would like to VEIW now which table would you like to view ");
            System.out.println("if you would like to veiw NormalIdentity table press 1");
            System.out.println("if you would like to veiw Superhero table press 2");
            System.out.println("if you would like to veiw Antihero table press 3");
            System.out.println("if you would like to veiw Villain table press 4");
            System.out.println("if you would like to veiw Team table press 5");
            System.out.println("if you would like to veiw Version table press 6");
            System.out.println("if you would like to veiw Superpower table press 7");
            System.out.println("if you would like to veiw Archenemy table press 8");
            System.out.println("if you would like to veiw Race table press 9");
            System.out.println("if you would like to veiw Dimension table press 10");
            System.out.println("if you would like to veiw all tables press 11");
            int whattablebuddy4 = input.nextInt();

              if (whattablebuddy4 == 1){
                System.out.println("now printing the NormalIdentity table");
              }
              if (whattablebuddy4 == 2){
                System.out.println("now printing the Superhero table");
              }
              if (whattablebuddy4 == 3){
                System.out.println("now printing the Antihero table");
              }
              if (whattablebuddy4 == 4){
                System.out.println("now printing the Villain table");
              }
              if (whattablebuddy4 == 5){
                System.out.println("now printing the Team table");
              }
              if (whattablebuddy4 == 6){
                System.out.println("now printing the Version table");
              }
              if (whattablebuddy4 == 7){
                System.out.println("now printing the Superpower table");
              }
              if (whattablebuddy4 == 8){
                System.out.println("now printing the Archenemy table");
              }
              if (whattablebuddy4 == 9){
                System.out.println("now printing the Race table");
              }
              if (whattablebuddy4 == 10){
                System.out.println("now printing the Dimension table");
              }
              if (whattablebuddy4 == 11){
                System.out.println("now printing the all tables");
              }

          }


        }
        if (entry == 0){
          System.out.println("please run program again and input correct password or go to new user");

        }
      }






  }
}
