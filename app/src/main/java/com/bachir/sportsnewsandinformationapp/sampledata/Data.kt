package com.bachir.sportsnewsandinformationapp.sampledata

import androidx.fragment.app.Fragment
import com.bachir.sportsnewsandinformationapp.fragments.AboutMeFragment
import com.bachir.sportsnewsandinformationapp.fragments.AthletesFragment
import com.bachir.sportsnewsandinformationapp.fragments.EventsFragment
import com.bachir.sportsnewsandinformationapp.fragments.HistoricalArchiveFragment
import com.bachir.sportsnewsandinformationapp.fragments.NewsFragment
import com.bachir.sportsnewsandinformationapp.fragments.SportsFragment
import com.bachir.sportsnewsandinformationapp.models.Archive
import com.bachir.sportsnewsandinformationapp.models.Athlete
import com.bachir.sportsnewsandinformationapp.models.Event
import com.bachir.sportsnewsandinformationapp.models.News
import com.bachir.sportsnewsandinformationapp.models.Sport
import com.bachir.sportsnewsandinformationapp.models.User
import com.bachir.sportsnewsandinformationapp.utils.SportType
import java.util.Date

object Data {
    val user = User(
        "Bachir Mecheref",
        mutableListOf("Software Engineer", "Full stack java developer", "Android developer"),
        "I am a motivated and versatile individual, always eager to take on new challenges. With a passion for learning I am dedicated to delivering high-quality results. With a positive attitude and a growth mindset, I am ready to make a meaningful contribution and achieve great things.",
        mapOf(
            "facebook" to "https://www.facebook.com/karim.krimooo.75",
            "linkedIn" to "https://www.linkedin.com/in/mecheref-bachir/",
            "github" to "https://github.com/mecheref-bachir"
        )

    )
    var listOfFragments: MutableList<Fragment> =
        mutableListOf(
            SportsFragment(),
            NewsFragment(),
            AthletesFragment(),
            EventsFragment(),
            HistoricalArchiveFragment(),
            AboutMeFragment()
        )
    var listOfFragmentsNames: MutableList<String> =
        mutableListOf(
            "Sports",
            "News",
            "Athletes",
            "Events",
            "Historical Archives",
            "About Me"
        )
    var listOfArchives = mutableListOf(
        Archive(
            "Indian Premier Archive",
            Date(2024, 11, 11),
            "hello this is a description for the Archive "
        ),
        Archive(
            "Indian second Archive",
            Date(2024, 11, 11),
            "hello this is a description for the Archive "
        ),
        Archive(
            "Indian Premier Archive",
            Date(2024, 11, 11),
            "hello this is a description for the Archive "
        )
    )
    var listOfEvents = mutableListOf<Event>(
        Event(
            "Indian Premier League",
            Date(2024, 11, 11),
            "hello this is a description for the event "
        ),
        Event(
            "Indian Premier League",
            Date(2024, 11, 11),
            "hello this is a description for the event "
        ),
        Event(
            "Indian Premier League",
            Date(2024, 11, 11),
            "hello this is a description for the event "
        ),
        Event(
            "Indian Premier League",
            Date(2024, 11, 11),
            "hello this is a description for the event "
        )

    )
    var listOfAthletes = mutableListOf<Athlete>(
        Athlete(
            "Usain Bolt",
            "Track and Field",
            "Jamaica",
            "100m - 9.58s",
            8,
            "Usain Bolt holds the world record for both the 100 meters and 200 meters"
        ),
        Athlete(
            "Usain Bolt",
            "Track and Field",
            "Jamaica",
            "100m - 9.58s",
            8,
            "Usain Bolt holds the world record for both the 100 meters and 200 meters"
        ),
        Athlete(
            "Usain Bolt",
            "Track and Field",
            "Jamaica",
            "100m - 9.58s",
            8,
            "Usain Bolt holds the world record for both the 100 meters and 200 meters"
        )

    )
    var ListOfSports = mutableListOf<Sport>(
        Sport(
            SportType.MEASURE,
            "Swimming",
            "Swimming is a measure of one's endurance and ability to navigate water. It involves various strokes like freestyle, breaststroke, backstroke, and butterfly. Swimmers compete in different distances, ranging from sprint events like 50m freestyle to longer distances like 1500m freestyle."
        ),
        Sport(
            SportType.PRECISION,
            "Archery",
            "Archery requires precision and accuracy in shooting arrows at a target. Competitors aim to hit the bullseye from a certain distance. It involves using a bow and arrow, focusing on proper stance, grip, and release technique. Archery competitions include outdoor, indoor, and field archery, each with unique challenges."
        ),
        Sport(
            SportType.SPECTACLE,
            "Gymnastics",
            "Gymnastics is a spectacle of strength, flexibility, and grace. It includes various disciplines like artistic gymnastics, rhythmic gymnastics, and trampoline. Artistic gymnastics involves performing routines on apparatus like the floor, balance beam, vault, and uneven bars. Rhythmic gymnastics combines dance, flexibility, and handling apparatus such as ribbon, hoop, and ball. Trampoline gymnastics showcases aerial acrobatics and skills performed on a trampoline."
        ),
        Sport(
            SportType.COMBAT,
            "Boxing",
            "Boxing is a combat sport where two opponents face off in a ring. It involves punches, footwork, and defense strategies to defeat the opponent. Boxers compete in different weight classes, from lightweight to heavyweight. The sport emphasizes physical conditioning, agility, and mental toughness. Boxing matches consist of rounds, and a boxer can win by knockout, technical knockout, decision, or disqualification."
        ),
        Sport(
            SportType.PLAY,
            "Football",
            "Football is a play-oriented team sport where two teams compete to score goals by getting the ball into the opposing team's net. It involves passing, dribbling, and teamwork. Football matches consist of two halves, each lasting 45 minutes, with additional time added for stoppages. Players aim to score goals using their feet, head, or any part of the body except the arms and hands. Positions include forwards, midfielders, defenders, and goalkeepers."
        )
    )
    var ListOfNews = mutableListOf<News>(
        News(
            "https://media.istockphoto.com/id/499772700/photo/little-boy-dribbling-a-basketball.jpg?s=1024x1024&w=is&k=20&c=ppO1mF9H8P_acLOoYq5lmvQvA_zVdY7Lums68iEalHU=",
            "New Study Shows Benefits of Regular Exercise",
            "A recent study published in the Journal of Health has shown that regular exercise can improve overall health and reduce the risk of chronic diseases."
        ),
        News(
            "https://media.istockphoto.com/id/175219547/photo/couple-kayaking-by-a-tropical-island-in-the-caribbean.jpg?s=1024x1024&w=is&k=20&c=tP3vRNATFk3lXjJSXUUvpw9FluIkYn6Tia7m3d8OFoA=",
            "New Art Exhibition Opens at City Museum",
            "The City Museum is hosting a new art exhibition showcasing works from local artists. The exhibition features a variety of paintings, sculptures, and photographs."
        ),
        News(
            "https://media.istockphoto.com/id/175219547/photo/couple-kayaking-by-a-tropical-island-in-the-caribbean.jpg?s=1024x1024&w=is&k=20&c=tP3vRNATFk3lXjJSXUUvpw9FluIkYn6Tia7m3d8OFoA=",
            "New Art Exhibition Opens at City Museum",
            "The City Museum is hosting a new art exhibition showcasing works from local artists. The exhibition features a variety of paintings, sculptures, and photographs."
        ),
        News(
            "https://media.istockphoto.com/id/175219547/photo/couple-kayaking-by-a-tropical-island-in-the-caribbean.jpg?s=1024x1024&w=is&k=20&c=tP3vRNATFk3lXjJSXUUvpw9FluIkYn6Tia7m3d8OFoA=",
            "New Art Exhibition Opens at City Museum",
            "The City Museum is hosting a new art exhibition showcasing works from local artists. The exhibition features a variety of paintings, sculptures, and photographs."
        ), News(
            "https://media.istockphoto.com/id/175219547/photo/couple-kayaking-by-a-tropical-island-in-the-caribbean.jpg?s=1024x1024&w=is&k=20&c=tP3vRNATFk3lXjJSXUUvpw9FluIkYn6Tia7m3d8OFoA=",
            "New Art Exhibition Opens at City Museum",
            "The City Museum is hosting a new art exhibition showcasing works from local artists. The exhibition features a variety of paintings, sculptures, and photographs."
        )
    )


}