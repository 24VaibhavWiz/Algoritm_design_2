package programming_projects;
class heuristic
{
	public static int new_Table[] =	{1,8,4,7,5,6,2,3};
	public static int table[]	=	{1,8,3,6,0,7,4,2,5};             
    public static int goalTable[] =	{1,2,3,8,0,4,7,6,5};         
    public static int blankSpot;                                                      
    public static int a=0, b=0, c=0, x;
    public static int numCorrect=0;
    public static int origNum, leftNum,rightNum,upNum,downNum;

       public static void main(String args[])
       {
                      puzzSolver();
       }
    static void puzzSolver()
    {
          int a;
          printinitvalues();       

          for (a=0; a<5; ++a)
                {
                      countTiles();
                      branch();
                      System.out.println(numCorrect);
                }
    }
    static void branch()
    {
          if (numCorrect<9)
                {
                      countTiles();
                      locateSpace();     
                      checkNum();
                      getLarge();
                      if(x==leftNum)
                            changeTableLeft();
                                  else if(x==rightNum)
                                        changeTableRight();
                                              else if(x==upNum)
                                                    changeTableUp();
                                                          else
                                                                changeTableDown();
                      printinitvalues();
                }
    }
    static void countTiles()
    {
          int i;
          numCorrect =0;
          for (i=0; i<9; ++i)
                {
                      if (new_Table[i]==goalTable[i])
                      {
                            numCorrect = numCorrect + 1;
                      }
                }
    }
    static void checkNum()
    {
          makeMoveLeft();              
          locateSpace();                
          countTiles();
          leftNum = numCorrect;
          resetTable();
          makeMoveUp();
          locateSpace();                 
          countTiles();
          upNum = numCorrect;
          resetTable();
          makeMoveRight();              
          locateSpace();                
          countTiles();
          rightNum = numCorrect;
          resetTable();
          makeMoveDown();             
          locateSpace();               
          countTiles();
          downNum = numCorrect;
          resetTable();
    }
    static void getLarge()
    {
          x=leftNum;

          if (x<rightNum)
                {
                      x=rightNum;
                }

          if (x<upNum)
                {
                      x=upNum;
                }

          if (x<downNum)
                {
                      x=downNum;
                }
    }
    static void changeTableLeft()
    {
          makeMoveLeft();
          int a;
          for (a=0; a<9; ++a)
          {
                table[a] = new_Table[a];
          }
    }
    static void changeTableRight()
    {
          makeMoveRight();
          int a;
          for (a=0; a<9; ++a)
                {
                      table[a] = new_Table[a];
                }
    }
    static void changeTableDown()
    {
          makeMoveDown();
          int a;
          for (a=0; a<9; ++a)
                {
                      table[a] = new_Table[a];
                }
    }
    static void changeTableUp()
    {
          makeMoveUp();
          int a;
          for (a=0; a<9; ++a)
                {
                      table[a] = new_Table[a];
                }
    }
    static void makeMoveLeft()
    {
          if(blankSpot!=0)
          {
                if (blankSpot !=3)
                {
                      if (blankSpot !=6)
                      {
                            int temp;
                            temp = table[blankSpot-1];
                                  if (temp != goalTable[blankSpot-1])
                                        {
                                              new_Table[blankSpot-1]=table[blankSpot];
                                              new_Table[blankSpot] = temp;
                                              countTiles();
                                        }
                      }
                }
          }
    }
    static void makeMoveRight()
    {
          if(blankSpot!=2)
                {
                      if (blankSpot !=5)
                            {
                                  if (blankSpot !=8)
                                        {
                                              int temp;
                                              temp = table[blankSpot+1];
                                              if (temp != goalTable[blankSpot+1])
                                                    {
                                                          new_Table[blankSpot+1]=table[blankSpot];
                                                          new_Table[blankSpot] = temp;
                                                          return;
                                                    }
                                        }
                            }
                }

    }
    static void makeMoveUp()
    {
          if(blankSpot!=0)
                {
                      if (blankSpot !=1)
                            {
                                  if (blankSpot !=2)
                                        {
                                              int temp;
                                              temp = table[blankSpot-3];
                                              if (temp != goalTable[blankSpot-3])
                                                    {
                                                          new_Table[blankSpot-3]=table[blankSpot];
                                                          new_Table[blankSpot] = temp;
                                                    }
                                        }
                            }
                }
    }
    static void makeMoveDown()
    {
          if(blankSpot!=6)
                {
                      if (blankSpot !=7)
                            {
                                  if (blankSpot !=8)
                                        {
                                              int temp;
                                              temp = table[blankSpot+3];
                                              if (temp != goalTable[blankSpot+3])
                                                    {
                                                          new_Table[blankSpot+3]=table[blankSpot];
                                                          new_Table[blankSpot] = temp;
                                                    }
                                        }
                            }
                }
    }
    static void printinitvalues()
          {
                int t, i=1;
                for (t=0; t<9; ++t)
                      {
                            System.out.print(table [t] + "  ");
                                  if (i == 3)                                         
                                        {
                                              System.out.println();
                                              i = i - 3;
                                        }
                            i = i + 1;
                      }
                            System.out.println();
                            System.out.println();
          }
    static void printGoalvalues()
    {
                int t, i=1;
                for (t=0; t<9; ++t)
                      {
                            System.out.print(goalTable [t] + "  ");
                                  if (i == 3)                                        
                                        {
                                              System.out.println();
                                              i = i - 3;
                                        }
                            i = i + 1;
                      }
                            System.out.println();
                            System.out.println();
    }
    static void printNewValues()
          {
                int t, i=1;
                for (t=0; t<9; ++t)
                      {
                            System.out.print(new_Table [t] + "  ");
                                  if (i == 3)                                   
                                        {
                                              System.out.println();
                                              i = i - 3;
                                        }
                            i = i + 1;
                      }
                            System.out.println();
                            System.out.println();
          }
    static void locateSpace()
    {
          int t;
          for (t=0; t<9; ++t)
                {
                      if (table[t]==0)
                            {
                                  blankSpot = t;
                                  return;
                            }
                }
    }
    static void resetTable()
    {
          int i;
          for (i=0; i<9; ++i)
          {
                new_Table[i]=table[i];
          }
    }
}

