document.addEventListener('DOMContentLoaded', function() {
    var messages = document.getElementById('messages');
    var userInput = document.getElementById('userInput');
    var sendBtn = document.getElementById('sendBtn');

    userInput.addEventListener('keydown', function(event) {
        if (event.keyCode === 13) { // 13 表示回车键的键码
            event.preventDefault(); // 阻止默认的回车换行行为
            sendMessage(userInput.value); // 调用发送消息的函数
            userInput.value = ''; // 清空输入框
        }
    });

    sendBtn.addEventListener('click', function() {
        var content = userInput.value;
        if (content.trim() !== '') {
            sendMessage(content);
            userInput.value = '';
        }
    });

    function sendMessage(content) {
        var message = document.createElement('div');
        message.className = 'message';
        message.textContent = '用户：' + content;
        messages.appendChild(message);

        // 使用fetch发送POST请求到askGpt接口
        fetch('http://coolcoder.top/askGpt', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ content: content })
        })
            .then(function(response) {
                return response.json();
            })
            .then(function(data) {
                var reply = data.re;
                var replyMessage = document.createElement('div');
                replyMessage.className = 'message';
                replyMessage.textContent = 'FunAI：' + reply;
                messages.appendChild(replyMessage);
            })
            .catch(function(error) {
                console.log('发送请求出错：', error);
            });
    }
});
