var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    $('#response').html();
}

function connect() {
    var socket = new SockJS('/stomp/endpoint'); //1
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/stomp/topic/greeting/obj', function(respnose){ //2
            showResponse(respnose.body);
        });
    });
}


function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    var name = $('#name').val();
    //3
    stompClient.send("/stomp/server/greeting/obj", {}, JSON.stringify({

        'from': 'fromuser',
        'to': 'touser',
        'message': name
    }));
}

function showResponse(message) {
    var response = $("#response");
    response.html(message);
}