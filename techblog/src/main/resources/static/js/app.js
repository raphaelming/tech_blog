console.log('connect');
var url = 'http://localhost:8080/boards';
var list = document.getElementById('list');
var button = document.getElementById('select');
var str = '';


getJSON(url, done);
// AjaxData(url);

function innerHtmlAction(){
  list.innerHTML = str;
}


function done(result) {
  for (var i = 0; i < result.data.length; i++) {
    str += '<h3>' + result.data[i].id + '</h3>'
    str += '<h3>' + result.data[i].tag + '</h3>'
    str += '<h3>' + result.data[i].title + '</h3>'
    str += '<h3>' + result.data[i].contents + '</h3>'
  }
  innerHtmlAction();
}

function clickButton(event){
  console.log('test1');
}


button.addEventListener('click', clickButton);
