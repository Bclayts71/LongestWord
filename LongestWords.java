import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class LongestWords
{
   public static ArrayList<String> getAnagrams(String thing)
   {
      Queue<CState> queue = new LinkedList<CState>();
      ArrayList<String> visited = new ArrayList<String>();
      CState start = new CState("", thing);
      queue.add(start);
      while (!queue.isEmpty())
      {
         CState word = queue.poll();
         if (word.suff().length() >0)
         {
            String prefix = word.pre() + word.suff().charAt(0);
            String suffix = word.suff().substring(1);
            visited.add(prefix);
            CState num1 = new CState(prefix, suffix);
            CState num2 = new CState(word.pre(), suffix);
            queue.add(num1);
            queue.add(num2);
         }
      }
      return visited;
   }   
   public static void main(String[] args)
   {
      UALDictionary<String, WordPair> dict = new UALDictionary<>();
      File file = new File("words.txt");
      Scanner inFile = null;  
      try
      {
         inFile = new Scanner(file);
         while (inFile.hasNextLine())
         {
            String line = inFile.nextLine();
            WordPair pair = new WordPair(line);
            dict.insert(pair.getSorted(), pair);
         }
      }
      catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
      inFile.close();      
      Scanner scan = new Scanner(System.in);
      String thing = scan.nextLine();
      ArrayList<String> list = new ArrayList<>();
      ArrayList<String> anagram = getAnagrams(thing);
      
      for (int i=0; i<anagram.size(); i++)
      {
         WordPair word = new WordPair(anagram.get(i));
         for(WordPair words : dict.findAll(word.getSorted()))
         {
            list.add(words.getUnsorted());
         }
      }
      list.sort((second,first) -> Integer.compare(first.length(), second.length()));
      ArrayList<String> str = new ArrayList<>();
      for(int j=0; j<list.size(); j++)
      {
         if (list.get(j).length() == list.get(0).length())
         {
            str.add(list.get(j));
         }
         else
         {
            break;
         }
      }
      Collections.sort(str);
      for(String count: str)
      {
         System.out.println(count);
      }
   }
}

   
