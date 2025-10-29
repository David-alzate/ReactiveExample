'use strict';
const webSocketUrl = 'ws://localhost:8080/chat-back-end';
const client = new StompJs.Client({brokerURL: webSocketUrl});

let buttonSendMessage;
let sectionMessageExchanged;
let buttonConnectToChat;
let buttonDisconnecttoChat;

window.addEventListener(
    'load', () => {
        buttonSendMessage = document.getElementById('sendMessageButton');
        sectionMessageExchanged = document.getElementById('sectionMessageExchanged');
        buttonConnectToChat = document.getElementById('connecToChatButton');
        buttonDisconnecttoChat = document.getElementById('disconnectToChatButton');

        buttonConnectToChat.disabled = false;
        buttonDisconnecttoChat.disabled = true;
        buttonSendMessage.disabled = true;
    }
);

function connect() {
    client.activate();
    buttonSendMessage.disabled = false;
    buttonConnectToChat.disabled = true;
    buttonDisconnecttoChat.disabled = false;
}

function disconnect() {
    client.deactivate();
    buttonSendMessage.disabled = true;
    buttonConnectToChat.disabled = false;
    buttonDisconnecttoChat.disabled = true;
}

function clearMessagesExchanged() {
    sectionMessageExchanged.innerHTML = "<tr><td colspan ='2'>Empty!</td>\</tr>";
}