
const database = [
    {
        question: 'James Brown is referred to by various honorific nicknames. Which one of these is incorrect?',
        correctAnswer: 'Godfather of Funk',
        wrongAnswer: ['The Hardest-Working Man in Show Business', 'Mr. Dynamite', 'Soul Brother No. 1']
    },

    {
        question: 'His musical career started in 1954. How long was it?',
        correctAnswer: '52',
        wrongAnswer: ['50', '53', '49']
    },

    {
        question: 'How many times was James Brown married?',
        correctAnswer: '3',
        wrongAnswer: ['1', '2', '4']
    },

    {
        question: 'He was one of the first _ inductees into the Rock and Roll Hall of Fame in 1986.',
        correctAnswer: '10',
        wrongAnswer: ['5', '7', '12']
    },

    {
        question: 'Brown had fully established the funk sound after the formation of "The J.B.’s" at the start of what decade?',
        correctAnswer: '70\'s',
        wrongAnswer: ['60\'s', '80\'s', '90\'s']
    },

    {
        question: 'James Brown died of what?',
        correctAnswer: 'Pneumonia',
        wrongAnswer: ['Cancer', 'Natural causes', 'Accident']
    },

    {
        question: 'How many singles reached No. 1 on the Billboard R&B charts?',
        correctAnswer: '17',
        wrongAnswer: ['14', '19', '22']
    },

    {
        question: 'In Rolling Stone’s list of the 100 Greatest Artists of All Time, James Brown was ranked No. _',
        correctAnswer: '7',
        wrongAnswer: ['5', '6', '8']
    },

    {
        question: 'At 16, he was convicted of robbery and sent to a juvenile detention center, where he formed a gospel quartet with how many fellow cellmates?',
        correctAnswer: '4',
        wrongAnswer: ['3', '5', '6']
    },

    {
        question: '“Live at the Apollo” sold over a million copies, staying on the charts for how many months?',
        correctAnswer: '14',
        wrongAnswer: ['9', '12', '16']
    },

    {
        question: 'Which song won him his first Grammy Award, in 1965?',
        correctAnswer: 'Papa’s Got a Brand New Bag',
        wrongAnswer: ['I Got You (I Fell Good)', 'Prisoner of Love', 'It’s a Man’s Man’s Man’s World']
    },

    {
        question: 'Brown performed in the Super Bowl XXXI halftime show in what year?',
        correctAnswer: '1997',
        wrongAnswer: ['1994', '1995', '1996']
    },

    {
        question: 'Brown made an appearance in what Rocky movie?',
        correctAnswer: 'Rocky IV',
        wrongAnswer: ['Rocky', 'Rocky II', 'Rocky III']
    },

    {
        question: 'How many studio albums does James Brown have?',
        correctAnswer: '59',
        wrongAnswer: ['47', '52', '56']
    },

    {
        question: 'How many live albums does James Brown have?',
        correctAnswer: '15',
        wrongAnswer: ['8', '13', '20']
    },

    {
        question: 'James Brown made an appearance on The Simpsons, as himself, in what year?',
        correctAnswer: '1993',
        wrongAnswer: ['1991', '1992', '1994']
    },

    {
        question: 'What actor plays the role of James Brown in the biopic film “Get on Up” (2014)?',
        correctAnswer: 'Chadwick Boseman',
        wrongAnswer: ['Michael B. Jordan', 'Winston Duke', 'Donald Glover']
    },

    {
        question: 'What is the name of first James Brown studio album?',
        correctAnswer: 'Please Please Please',
        wrongAnswer: ['Try Me!', 'Think!', 'The Amazing James Brown']
    },

    {
        question: 'In what year did James Brown released is last studio album?',
        correctAnswer: '2002',
        wrongAnswer: ['1999', '2000', '2001']
    },

    {
        question: 'How many studio albums did James Brown released in 1968?',
        correctAnswer: '5',
        wrongAnswer: ['2', '3', '4']
    },

    {
        question: 'James Brown released how many singles is his career?',
        correctAnswer: '144',
        wrongAnswer: ['141', '149', '137']
    },
];

const startImage = [
    'url("resources/images/jamesbrownposter1.jpg")',
    'url("resources/images/jamesbrownposter2.jpg")',
    'url("resources/images/jamesbrownposter3.jpg")',
    'url("resources/images/jamesbrownposter4.png")',
    'url("resources/images/jamesbrownposter5.jpg")'
];

const finalMessage = [
    'You\'re on the path to becoming a big fan of James Brown!',
    'Your knowledge of James Brown is growing – keep up the great work!',
    'Impressive! You have a solid understanding of James Brown\'s legacy.',
    'You\'re truly a dedicated fan with an in-depth grasp of James Brown\'s impact.',
    'Your expertise on James Brown is astounding – you\'re a true connoisseur!'
];

let flag = false;
let counterWrong = 0;
let counterRights = 0;
let factor = 5;
const audioGame = new Audio("resources/sound/James Brown - Super Bad (Parts 1 & 2) ft. The Original J.B.s (64 kbps).mp3");

const data = randomQuestions(10);
let questionCounter = 0;

window.onload = (event) => {

    selectRandomImg();
}

function selectRandomImg() {
    const randomImg = document.querySelector(".menu");
    randomImg.style.background = startImage[Math.floor(Math.random() * startImage.length)];
    randomImg.style.backgroundSize = "cover";
    randomImg.style.backgroundPosition = "center";
    randomImg.style.backgroundRepeat = "no-repeat";
}

document.querySelector("#start").addEventListener("click", function () {

    document.querySelector(".menu").style.display = "none";
    start(data[questionCounter]);

})

document.querySelector("#goBack").addEventListener("click", function () {

    document.querySelector(".menu").style.display = "none";
    
})

// Get 10 random questions from our database
function randomQuestions(num) {
    const toReturn = [];

    while (toReturn.length < num) {

        let randomIndex = Math.floor(Math.random() * database.length);

        if (toReturn.includes(database[randomIndex])) {
            continue;
        }

        toReturn.push(database[randomIndex]);
    };

    return toReturn;
}

// Start the quiz with our questions
function start(q) {


    document.querySelector(".container").style.display = "flex";

    const question = document.querySelector(".query");
    question.innerHTML = `<h3 class="question">#${questionCounter + 1} - ${q.question}</h3>`;
    console.log(question);

    const content = document.querySelector(".list");
    q.wrongAnswer.splice(Math.random() * (q.wrongAnswer.length + 1), 0, q.correctAnswer);

    var list = q.wrongAnswer.map((request, index) => `<li id=${index}>${request}</li>`).join('')
    content.innerHTML = list

    document.querySelector(".score").textContent = `Score: ${counterRights * factor}`;

    checkAnswer(q);

}

function checkAnswer(q) {
    audioGame.pause()
    audioGame.play();

    const answerItens = document.querySelectorAll('li')
    const correctAnswer = q.correctAnswer;
    console.log(correctAnswer)
    var counter = 0;
    var maxAttempts = 1;

    for (let i = 0; i < answerItens.length; i++) {
        console.log("here");

        answerItens[i].addEventListener('click', function (event) {

            counter++;

            const selectedAnswer = event.target.textContent
            const clicked = event.currentTarget

            if (counter === maxAttempts) {

                if (selectedAnswer === correctAnswer) {
                    const audioRight = new Audio("resources/sound/RigthQuestion.mp3")
                    audioRight.play()

                    flag = true;


                    clicked.style.backgroundColor = "green";
                    i = answerItens.length;
                } else {

                    const audioRight = new Audio("resources/sound/WrongQuestion.mp3")
                    audioRight.play()

                    flag = false;
                    clicked.style.backgroundColor = "red";


                    i = answerItens.length;
                }

            }

            setTimeout(function () {
                showAnswer(q)
            }, 500)

        });
    }
}

function showAnswer(q) {
    if (flag) {

        document.querySelector(".container").remove();
        document.querySelector(".show").style.display = "flex";

        document.querySelector(".show").style.color = "white";
        document.querySelector(".show").style.backgroundColor = "rgb(50, 215, 50)";
        document.querySelector(".show").textContent = "You got it right!";
        document.querySelector(".show").style.fontSize = "50px";
        setTimeout(function () {

            document.querySelector("body").innerHTML = `<div class="show"></div>
            <div class="container">
                <div class="exitContainer">
                    <div class="exit">
                        <input class="exitButton" type="image" src="resources/images/yellowCross.png" alt="Exit Button" onclick="exit()">
                    </div>
                </div>
                <div class="header-questions">
                   
                </div> 
                <div class="query">
                
                </div>
                <div class="content">
                    <ul class="list">
                       
                    </ul>
                </div>
                <div class="scoreContainer">
                <div class="score">
                    
                </div>
            </div>
            </div> `

            counterRights++;
            audioGame.pause();
            audioGame.play();

            questionCounter++;
            console.log("Question Counter: " + questionCounter);

            if (questionCounter >= data.length) {
                endGame();
                return;
            } else {
                start(data[questionCounter]);
            }

        }, 1500)
    } else {
        document.querySelector(".container").remove();
        document.querySelector(".show").style.display = "flex"
        document.querySelector(".show").style.color = "white";
        document.querySelector(".show").style.backgroundColor = "rgb(215, 50, 50)";
        document.querySelector(".show").textContent = "Correct Answer: "
            + q.correctAnswer;
        document.querySelector(".show").style.fontSize = "50px";

        setTimeout(function () {
            document.querySelector("body").innerHTML = `<div class="show"></div>
            <div class="container">

            <div class="exitContainer">
                <div class="exit">
                    <input class="exitButton" type="image" src="resources/images/yellowCross.png" alt="Exit Button" onclick="exit()">
                </div>
            </div>
                <div class="header-questions">
                   
                </div> 
                <div class="query">
                
                </div>
                <div class="content">
                    <ul class="list">
                       
                    </ul>
                </div>
                <div class="scoreContainer">
                <div class="score">
                    
                </div>
            </div>
            </div> `

            counterWrong++;
            audioGame.pause();
            audioGame.play();

            questionCounter++;
            if (questionCounter >= data.length) {
                endGame();
                return;
            } else {
                start(data[questionCounter]);
            }

        }, 2000)
    }

}

function getFinalMessage() {
    const result = counterRights * factor;

    if (result < 15) {
        return finalMessage[0];
    }
    if (result < 25) {
        return finalMessage[1];
    }
    if (result < 35) {
        return finalMessage[2];
    }
    if (result < 45) {
        return finalMessage[3];
    }
    return finalMessage[4];
}

function endGame() {

    const msg = getFinalMessage();

    document.querySelector(".container").remove();
    document.querySelector(".show").style.display = "flex";
    document.querySelector(".show").style.backgroundColor = "cornflowerblue";

    document.querySelector(".show").innerHTML = `<span style="font-size: 40px">Your score is:  ${counterRights * factor}</span>
                                                <span style="font-size: 30px">${msg}</span>
                                                <div class="center">
                                                    <button onclick="exit()"">Reset</button>
                                                </div>`
}

function exit() {
    location.reload();
}
