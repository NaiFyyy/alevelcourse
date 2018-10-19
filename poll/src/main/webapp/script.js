var questionInput = document.getElementById("question-input");
var pollsHtml = document.getElementById("polls");
var polls = [];

function setupListeners() {
    questionInput.addEventListener('keyup', function (event) {
        if (event.key === 'Enter') {
            inputQuestion();
        }
    });
    document.getElementById('add').addEventListener('click', function () {
        inputQuestion();
    });
}

function inputQuestion() {
    var inputValue = questionInput.value;
    if (inputValue === '') {
        alert("You must write something!");
        return;
    }
    var newPoll = {
        question: inputValue
    };

    axios.post('poll', newPoll)
        .then(function (result) {
            newPoll.id = result.data.id;
            addElement(newPoll);
            questionInput.value = '';
        })
        .catch(function (reason) {
            console.error(reason);
        });
}

function addElement(poll) {
    var list = document.createElement('li');
    list.appendChild(document.createTextNode(poll.text));
    pollsHtml.appendChild(list);
    polls.push(poll);
}