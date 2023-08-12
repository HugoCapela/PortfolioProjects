var API_URL_ENTERTAINMENT_VIDEOGAMES = 'https://opentdb.com/api.php?amount=10&category=15&difficulty=easy&type=boolean';

var questions = [];
var counter = 0;
var score = 0;

$(document).ready(function () {

    fetchData();

});

function fetchData() {

    resetGlobal();

    fetch(API_URL_ENTERTAINMENT_VIDEOGAMES)
        .then(response => response.json())
        .then(data => {
            //console.log(data);
            questions = data.results;
            populate();

            /* console.log(data);
            console.log(questions); */
        })
        .catch(error => {
            console.log(error);
        });
}

function resetGlobal() {
    questions = [];
    counter = 0;
    score = 0;
    clearPage();
}

function populate() {
    console.log(questions[counter]);
    console.log(counter);
    clearPage();
    createCategory(questions[counter].category);
    createScore();
    createQuestion(questions[counter].question);
    createButtons(questions[counter].correct_answer);
}

function clearPage() {

    var cat = $('#category');
    var points = $('#points');
    var q = $('#question');
    var btnT = $('#btn-true');
    var btnF = $('#btn-false');
    var btnE = $('#new-category');

    cat.empty();
    points.empty();
    q.empty();
    btnT.empty();
    btnF.empty();
    btnE.empty();
}

function createCategory(category) {
    var cat = $('#category');
    cat.append('<h1>' + category + '</h1>');
}

function createScore() {
    var points = $('#points');
    points.append('<h2>Your score is ' + score + '</h2>');
}

function createQuestion(question) {
    var q = $('#question');
    q.append('<h2>#' + (counter + 1) + ' - ' + question + '</h2>');
}

function createButtons(correct_answer) {

    var btnT = $('#btn-true');
    var btnF = $('#btn-false');

    btnT.append('<input class="btn btn-outline-primary" type="button" value="True" id="true" style="width: 100%"/>');
    btnF.append('<input class="btn btn-outline-primary" type="button" value="False" id="false" style="width: 100%"/>');

    btnT.off().on("click", function (event) {


        if (correct_answer === 'True') {

            console.log("correct");
            score += 1;

            nextQuestion();
        } else {

            console.log(counter);
            console.log("wrong");

            nextQuestion();
        }
    });

    btnF.off().on("click", function (event) {

        if (correct_answer === 'False') {

            console.log("correct");
            score += 1;

            nextQuestion();
        } else {

            console.log("wrong");

            nextQuestion();
        }
    });
}

function nextQuestion() {
    counter++;

    if (counter >= questions.length) {
        setTimeout(endGame, 1000);
        return;
    }

    setTimeout(populate, 1000);
}

function endGame() {
    clearPage();
    var cat = $('#category');
    cat.append('<h1>End Quizz! Your score was: ' + score + '!</h1>');

    var restart = $('#new-category');
    restart.append('<input class="btn btn-outline-success" type="button" value="Restart Game" id="restart" style="width: 100%"/>');

    restart.off().on("click", function (event) {
        return fetchData();
    });
}