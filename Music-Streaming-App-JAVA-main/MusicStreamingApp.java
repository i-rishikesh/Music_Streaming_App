//Music Streaming Application 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Song 
{
    private String title;
    private String artist;
    public Song(String title, String artist) 
    {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getArtist() 
    {
        return artist;
    }
}

class MusicStream 
{
    private List<Song> playlist;
    private boolean isPlaying;
    private int currentSongIndex;
    public MusicStream() 
    {
        playlist = new ArrayList<>();
        isPlaying = false;
        currentSongIndex = 0;
    }

    public void addSong(String title, String artist) 
    {
        Song song = new Song(title, artist);
        playlist.add(song);
        System.out.println("Added song: " + song.getTitle() + " by " + song.getArtist());
    }

    public void play() 
    {
        if (playlist.isEmpty()) 
        {
            System.out.println("No songs in the playlist.");
            return;
        }
        if (isPlaying) 
        {
            System.out.println("Music is already playing.");
            return;
        }
        isPlaying = true;
        Song currentSong = playlist.get(currentSongIndex);
        System.out.println("Playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    }

    public void pause() 
    {
        if (!isPlaying) 
        {
            System.out.println("Music is already paused.");
            return;
        }
        isPlaying = false;
        System.out.println("Music paused.");
    }

    public void resume() 
    {
        if (isPlaying)
        {
            System.out.println("Music is already playing.");
            return;
        }
        isPlaying = true;
        Song currentSong = playlist.get(currentSongIndex);
        System.out.println("Resuming: " + currentSong.getTitle() + " by " + currentSong.getArtist());
    }

    public void next() 
    {
        if (playlist.isEmpty()) 
        {
            System.out.println("No songs in the playlist.");
            return;
        }
        if (currentSongIndex < playlist.size() - 1) 
        {
            currentSongIndex++;
        } 
        else 
        {
            currentSongIndex = 0;
        }
        play();
    }

    public void previous() {
        if (playlist.isEmpty()) 
        {
            System.out.println("No songs in the playlist.");
            return;
        }
        if (currentSongIndex > 0) 
        {
            currentSongIndex--;
        } 
        else 
        {
            currentSongIndex = playlist.size() - 1;
        }
        play();
    }

    public void stop() 
    {
        if (!isPlaying) 
        {
            System.out.println("Music is already stopped.");
            return;
        }
        isPlaying = false;
        System.out.println("Music stopped.");
    }

    public void displayPlaylist() 
    {
        if (playlist.isEmpty()) 
        {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("----- Playlist -----");
        for (int i = 0; i < playlist.size(); i++) 
        {
            Song song = playlist.get(i);
            System.out.println((i + 1) + ". " + song.getTitle() + " by " + song.getArtist());
        }
    }
}

public class MusicStreamingApp 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        MusicStream musicStream = new MusicStream();
        while (true) 
        {
            System.out.println("----- Music Streaming Application -----");
            System.out.println("1. Add Song\n2. Play\n3. Pause\n4. Resume\n5. Next\n6. Previous\n7. Stop\n8. Display Playlist\n0. Exit\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the title of the song: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the artist of the song: ");
                    String artist = scanner.nextLine();
                    musicStream.addSong(title, artist);
                    break;
                case 2:
                    musicStream.play();
                    break;
                case 3:
                    musicStream.pause();
                    break;
                case 4:
                    musicStream.resume();
                    break;
                case 5:
                    musicStream.next();
                    break;
                case 6:
                    musicStream.previous();
                    break;
                case 7:
                    musicStream.stop();
                    break;
                case 8:
                    musicStream.displayPlaylist();
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
