import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
        Movie movie1 = new Movie(1,"Django Livre","Faroeste","É um escravo liberto cujo passado brutal o leva a ser um caçador de recompensas");
        Movie movie2 = new Movie(2,"Bastardos Inglórios","Guerra","A história de dois planos para assassinar os líderes políticos da Alemanha nazista");
        Movie movie3 = new Movie(3,"Era uma Vez em... Hollywood","Comédia","Em 1969, Sharon Tate e quatro amigos foram alvo da família Manson");
        Movie[] Movies = {movie1,movie2,movie3};

        Assessment feedback1 = new Assessment(1,"Garibalde",5,"O filme é fantástico!!! Não me canso de ver");
        Assessment feedback2 = new Assessment(1,"Vanzo",1,"ÉÉÉÉÉÉ! ISSO AQUI É UMA PORCARIA");
        Assessment feedback3 = new Assessment(1,"Ryan",4,"Eu espera mais do filme");

        Assessment feedback4 = new Assessment(2,"Gilson",4,"Excelente filme com bons argumentos, fotografia e trama envolvente");
        Assessment feedback5 = new Assessment(2,"Eduardo",1,"Não me convenceu. Achei o roteiro fraco, com situações que poderiam ser muito melhor exploradas");
        Assessment feedback6 = new Assessment(2,"Pedro",4,"Receita de sucesso: Tarantino, Waltz e um elenco impecável....");

        Assessment feedback7 = new Assessment(3,"Jorge",5,"Impecável esta obra. Tarantino e sua gangue são deslumbrantes");
        Assessment feedback8 = new Assessment(3,"Clara",5,"Simplesmente maravilhoso!!! a musica e fantastica.....!!!! assistam");
        Assessment feedback9 = new Assessment(3,"Alice",4,"Excelente, apenas isso a dizer");

        Assessment[] opinions = { feedback1, feedback2, feedback3, feedback4, feedback5, feedback6, feedback7, feedback8, feedback9 }; 

        VideoLibrary collection = new VideoLibrary(Movies);
        Opinions comments = new Opinions(opinions);
        
        collection.showAll();
        
        System.out.print("\n");
        
        comments.showAll();
        
	}
	
    public static Movie input()
    {
        Scanner input = new Scanner(System.in);
        int code = input.nextInt();
        String name = input.nextLine();
        String genre = input.nextLine();
        String synopsis = input.nextLine();
        Movie movie = new Movie(code, name, genre, synopsis);
        input.close();
        
        return movie;
    }
    
    public Movie[] createVector(int tam)
    {
        Movie[] Movies = new Movie[tam];
        for(int i = 0; i < Movies.length ; i++)
        {
            Movie movie = input();
            Movies[i] = new Movie( movie.getCode(), movie.getName(), movie.getGenre(), movie.getSynopsis() );
        }
        return Movies;
    }
    
}
class Movie
{
    private int code;
    private String name;
    private String genre;
    private String synopsis;
    
    Movie(int code, String name, String genre, String synopsis)
    {
        this.code = code;
        this.name = name;
        this.genre = genre;
        this.synopsis = synopsis;
    }

    public void setCode(int code)
    {
        this.code = code;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setGenre(String type)
    {
        this.genre = type;
    }
    
    public void setSynopsis(String description)
    {
        this.synopsis = description;
    }

    public String getName()
    {
        return this.name;
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    public String getSynopsis()
    {
        return this.synopsis;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public String toString() 
    {
    	return "Code: " + code + "\nName: " + name + "\nGenre: " + genre + "\nSynopsis: " + synopsis + "\n";
    }

}

class Assessment
{
    private int code;
    private String username;
    private int grade;
    private String comment;
    
    Assessment(int code, String username, int grade, String comment)
    {
        this.code = code;
        this.username = username;
        this.grade = grade;
        this.comment = comment;
    }
    
    public void setCode(int code)
    {
        this.code = code;
    }
    
    public void setUsername(String name)
    {
        this.username = name;
    }
    
    public void setGrade(int grade)
    {
        this.grade = grade;
    }
    
    public void setComment(String feedback)
    {
        this.comment = feedback;
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    public int getGrade()
    {
        return this.grade;
    }
    
    public String getComment()
    {
        return this.comment;
    }
    
    public String getUsername()
    {
        return this.username;                       
    }
    
    public String toString()
    {
    	return "Code: " + code + "\nUsername: " + username + "\nGrade: " + grade + "\nComment: " + comment + "\n";
    }
    
}

class VideoLibrary
{
    private Movie[] Movies;
    
    VideoLibrary(Movie[] Movies)
    {
        this.Movies = Movies;
    }
    
    public void setMovie(Movie[] Movie)
    {
        this.Movies = Movie;
    }
    
    public Movie[] getMovies()
    {
        return this.Movies;
    }
    
    public int searchMovie(String word)
    {
        int name;
        int synopsis;
        for(int i = 0; i < Movies.length; i++)
        {
            name = this.Movies[i].getName().indexOf(word);
            synopsis = Movies[i].getSynopsis().indexOf(word);
            if (name != -1)
            {
                System.out.printf("Movie encontrado [%s] , pesquisa por nome voltou em: %d\n",Movies[i].getName(),name);
                return name;
            }
            if (synopsis != -1)
            {
                System.out.printf("Movie encontrado [%s] , pesquisa por synopsis voltou em: %d\n",Movies[i].getName(),synopsis);
                return synopsis;
            }
        }
        return -1;
    }
    
    public void showMovie()
    {

        System.err.printf("Para mostrar todos os Movies digite all%n Procurar por genero, apenas digite-o:%n");
        Scanner input = new Scanner(System.in);
        String op = input.nextLine();
        
        if (op == "all")
        {
            for(int i = 0;i < getMovies().length; i++)
            {
                System.out.printf("%s\n",this.Movies[i].getName());
            }
        }
        else
        {
            System.out.print("Encontrei os seguintes Movies:\n");
            for(int i = 0; i < getMovies().length; i++)
            {

                if (op == getMovies()[i].getGenre())
                {
                    System.out.printf("[%s]%n",getMovies()[i].getName());
                }
            }
        }
        
        input.close();
    }
    
    public void showAll()
    {
        for(int i = 0;i < getMovies().length; i++)
        {
            System.out.print(getMovies()[i]);
        }
    }
    
}

class Opinions
{
    private Assessment[] feedback;
    
    Opinions(Assessment[] feedback)
    {
        this.feedback = feedback;
    }
    
    public void setFeedback(Assessment[] opinion)
    {
        this.feedback = opinion;
    }
    
    public Assessment[] getFeedback()
    {
        return this.feedback;
    }
    
    public double averageAssessment(int code)
    {
        double average = 0;
        int sum = 0;
        for(int i = 0; i < getFeedback().length; i++)
        {
            if (getFeedback()[i].getCode() == code)
            {
                average = average + getFeedback()[i].getGrade();
                sum++;
            }
        }
        if (sum == 0)
        {
            System.out.print("Não foi possível encontrar um Movie com este identificador");
            return 0;
        }
        return average/sum;
    }
    
    public int bestAssessment(int code)
    {
        int best = -1;

        for (int i = 0; i < getFeedback().length; i++)
        {
            if (code == getFeedback()[i].getCode())
            {
                int grade = getFeedback()[i].getGrade();
                if (grade == 5)
                {
                    return grade;
                }
                else if ( best < grade)
                {
                    best = grade;
                }
            }
        }
        if (best == -1)
        {
            System.out.print("Nenhum Movie encontrado com esse código.");
            return best;
        }
        return best;
    }
    
    public int worstAssessment(int code)
    {
        int worst = 6;

        for (int i = 0;i < getFeedback().length; i++)
        {
            if (code == getFeedback()[i].getCode())
            {
                int grade = getFeedback()[i].getGrade();
                if (grade == 0)
                {
                    return grade;
                }
                else if (grade < worst)
                {
                	worst = grade;
                }
            }
        }
        if (worst > 5)
        {
            System.out.print("Não consigo encontrar filmes com este código.");
            return worst;
        }
        return worst;
    }
    
    public void showAll()
    {
        for(int i = 0;i < getFeedback().length; i++)
        {
            System.out.print(getFeedback()[i]);
        }
    }
    
} 
