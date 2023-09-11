var audio;

var musicData = [
    { "id": 1, "name": "SuperBad", "album": "Revolution of the Mind: Live at the Apollo, Volume III", "genre": "Funk", "year": "1970", "songwriter": "James Brown", "producer": "James Brown", "rating": "Number 1 on the R&B chart and number 13 on the Billboard Hot 100", "img": "resources/images/1.jpg" },
    { "id": 2, "name": "Get Up (I Feel Like Being a) Sex Machine", "album": "Sex Machine", "genre": "Funk, Soul, Rhythm and blues ", "year": "1970", "songwriter": "James Brown, Bobby Byrd, Ron Lenhoff ", "producer": "James Brown", "rating": "Number 2 US Billboard Best Selling Soul Singles and  number 15 on the Billboard Hot 100", "img": "resources/images/2.jpg" },
    { "id": 3, "name": "It’s a Man’s Man’s Man’s World", "album": "It's a Man's Man's Man's World", "genre": "Funk", "year": "1966", "songwriter": "James Brown, Alfred Ellis ", "producer": "James Brown", "rating": "4/5:The Rolling Stone Album Guide", "img": "resources/images/3.jpg" },
    { "id": 4, "name": "Say It Loud - I'm Black and I’m Proud", "album": "Say It Loud – I’m By It Loud – I'm Black and I'm Proud", "genre": "Funk", "year": "1968", "songwriter": "James Brown, Alfred Ellis", "producer": "James Brown", "rating": "4/5:The Rolling Stone Album Guide", "img": "resources/images/4.jpg" },
    { "id": 5, "name": "Cold Sweat", "album": "Cold Sweat", "genre": "Funk", "year": "1967", "songwriter": "ames Brown, Alfred Ellis", "producer": "James Brown", "rating": "No. 1 R&B hit, and reached number seven on the Pop Singles chart.", "img": "resources/images/5.jpg" },
    { "id": 6, "name": "Please, please, please ", "album": "Please, please, please ", "genre": "Rhythm and blues, Rock'n'roll", "year": "1956", "songwriter": "James Brown", "producer": "Ralph Bass", "rating": "Number 6 on the R&B charts.", "img": "resources/images/6.jpg" },
    { "id": 7, "name": "I Got the Feelin’", "album": "I Got the Feelin’", "genre": "Funk", "year": "1970", "songwriter": "James Brown, John Terry", "producer": "James Brown", "rating": "Number 1 on the R&B chart and #6 on the pop chart", "img": "resources/images/7.jpg" },
    { "id": 8, "name": "Papa’s Got a Brand New Bag", "album": "Papa’s Got a Brand New Bag", "genre": "Soul, Funk", "year": "1965", "songwriter": "James Brown", "producer": "James Brown", "rating": "Number 72 on Rolling Stone Magazine's list of the 500 greatest songs of all time.peaking at number eight, and was a number-one R&B hit", "img": "resources/images/8.jpg" },
    { "id": 9, "name": "Living In America", "album": "Living in America", "genre": "Funk", "year": "1965", "songwriter": "Dan Hartman, Charlie Midnight", "producer": " Dan Hartman", "rating": "Number 4 on the Billboard Hot 100 chart.", "img": "resources/images/9.jpg" },
    { "id": 10, "name": "I Got You (I Feel Good)", "album": "Out of the Sight", "genre": "Soul, Funk", "year": "1965", "songwriter": "James Brown", "producer": "James Brown", "rating": "number 1 US Billboard Rhythm and Blues Singles[7, number 1 US Billboard Hot 100", "img": "resources/images/10.jpg" },
];



function showDetails(elem) {

    const rotatedElements = document.querySelector(".translate");
    if (rotatedElements != null && rotatedElements != undefined) {

        rotatedElements.className = "thecard1";
    }

    elem.setAttribute("class", "thecard1 translate");

    const audioPath = 'resources/music/#ID#.mp3'
    var audioFullPath = "";
    audioFullPath = audioPath.replace("#ID#", elem.id)

    if (audio != undefined) {
        audio.pause();
    }

    audio = new Audio(audioFullPath);
    audio.play();

}

window.onload = (event) => {

    renderData();
}

function pause() {
    audio.pause();
}

const htmlCard = `<div id="#ID#" class="thecard1" onclick="showDetails(this)">
  
<div class="thefront"><img src="#IMAGE#"/></div>

<div class="theback"><h1>#NAME#</h1><p>ALBUM  #ALBUM#</p><p>GENRE  #GENRE#</p><p>YEAR  #YEAR#</p><p>SONGWRITER  #SONGWRITER#</p><p>PRODUCER  #PRODUCER#</p><p>CHARTS  #CHARTS#</p> 

</div>

<div class="buttons-container" style="background-color: black;">
<!-- TODO -->
<a href="slide.html" style="text-decoration: none;"><h1 style="font-size: 20px; color: rgb(205, 227, 131); line-height: 2; letter-spacing: 4px;">
    Return to main menu</h1></a>
</div>

</div>`

function renderData() {

    const maxElementsPerRow = 5;

    const outerContainer = document.querySelector(".outerContainer");
    var html = '<div class="maincontainer2">';

    for (var i = 0; i < musicData.length; i++) {

        if (i === maxElementsPerRow) {
            html += `
            </div>
            <div class="maincontainer2">`;
        }

        html += htmlCard.replace('#NAME#', musicData[i].name).replace('#ALBUM#', musicData[i].album).replace('#ID#', musicData[i].id).replace('#GENRE#', musicData[i].genre).replace('#YEAR#', musicData[i].year).replace('#SONGWRITER#', musicData[i].songwriter).replace('#PRODUCER#', musicData[i].producer).replace('#CHARTS#', musicData[i].rating).replace('#IMAGE#', musicData[i].img);

    }

    html += '</div>'

    html += `<div class="buttons-container" style="background-color: black; display:flex; justify-content: center;">
        <!-- TODO -->
        <a href="main.html" style="text-decoration: none;"><h1 style="font-size: 20px; color: rgb(205, 227, 131); line-height: 2; letter-spacing: 4px; font-family: Arial, Helvetica, sans-serif;
        line-height: 2;">
          Return to main menu</h1></a>
    </div>`;

    outerContainer.innerHTML = html;


}

