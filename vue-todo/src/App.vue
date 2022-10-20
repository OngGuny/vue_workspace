<template>
<div id="app">
  <TodoHeader></TodoHeader>
  <TodoInput v-on:addTodo="addTodo"></TodoInput>
  <TodoList v-bind:propsdata="todoItems" v-bind:propsid="todoItemids" @removeTodo="removeTodo"></TodoList>
  <TodoFooter v-on:removeAll="clearAll"></TodoFooter>
</div>
</template>
<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoFooter from './components/TodoFooter.vue'
import TodoList from './components/TodoList.vue'
import TodoInput from './components/TodoInput.vue'

const tItems = []; //this todoItems를 못찾으니까 스크립트로 변수만들어서 data 에 다시 넣어줌
const todoIds=[];
export default {
  //data() List에 있던거 가져옴 이제 app.vue 에서 관리하겠다는거.

  data() {
    return {
      todoItems: tItems,
      todoItemids: todoIds,
      newTodoItem: "", //초기 에는 null. 위의 템플릿이 시작되면 여기있는 데이터 주겠다는것.
      newTodoTime: "",
      showModal: false

    }
  },

  //list 에 있던거 들고옴
  created() {
this.todoList();
    // let storageLength = localStorage.length; //계속 연산자를 호출 하기보단 담아서 뿌림 객체뽀개ㅔ기
    // if (storageLength > 0) {
    //   for (let i = 0; i<storageLength; i++) {
    //     this.todoItems.push(localStorage.key(i));
    /*<-pop    배열에 담기는 순서     <- push*/
    //   } //fora
    // } //if
  }, //created
  // input 에 있던거 들고옴 addtodo 라는 이벤트 추가

  components: {
    'TodoHeader': TodoHeader,
    'TodoInput': TodoInput,
    'TodoFooter': TodoFooter,
    'TodoList': TodoList,
  }, //components

  methods: {
    addTodo(todo, time) {
      /*
      동적 데이터 처리
      impl 에서 아이디 가져오는 메소드 만들어줌./
      아래 axios 에서 리스폰스 담아올때 아이디도 같이 받아옴
      여기에 새로운 지역변수 생성해줌
      let todo = todoitemids;
      여기에 새로 만든 글의 아이디를 담아줌. push로


      listTodo 에서도 담아줌
      협업해서 만든거에선 listTodo에서도 새로운 let 선언해서
      itemids 담아줌

      이렇게하면  일정 새로 만들고
      새로고침 안해도 바로 지우기가 가능해짐 
      */
      console.log(typeof todo + "Emldnrk" + todo);
      console.log(typeof time + "DWDWD" + time);
      axios.get("http://localhost:9999/Todo_1019Task/jsp/writeProc.jsp?todo=" + todo + "&time=" + time, {
          xhrFields: {
            withCredentials: true
          }
        })
        .then(function(response) {
          console.log(response);
          tItems.push("할 일 "+response.data.todos+ " "
          +"할 때"+response.data.time);
          console.log("Your todo is writen.");
        })
        .catch(function(error) {
          console.log(error);
        })

      // axios.get("http://localhost:8888/Todo_1019Task/jsp/writeProc.jsp")
      // .then(function(response){
      // });
      //  localStorage.setItem(todoItem, todoItem);

    }, //addTodo
    todoList(){
      axios.get("http://localhost:9999/Todo_1019Task/jsp/listProc.jsp", {
        xhrFields: {
          withCredentials: true
        }
      })
      .then(function(response) {
        for (let i = 0; i < response.data.length; i++) {
          tItems.push(
            "할 일 "+response.data[i].todos+ " "
            +"할 때"+response.data[i].time
          );
          todoIds.push(response.data[i].id);
        };
        console.log(todoIds)
      })
      .catch(function(error) {
        console.log(error);
      })
    },
    removeTodo(todoItem, index,todoItemids) {
      console.log(todoItem)

      axios.get("http://localhost:9999/Todo_1019Task/jsp/deleteProc.jsp?id=" + todoItemids).then(function(response) {
        console.log(response);
        console.log("Your schedul is deleted.")
      });
      this.todoItems.splice(index, 1);
    }, //removeTodo

    //footer 에 있떤거 들고옴
    clearAll() {
      axios.get("http://localhost:9999/Todo_1019Task/jsp/deleteProc.jsp?all=" + "all")
        .then(function(response) {
          console.log("Every todo is deleted, " + response + " see?");
        });
      // localStorage.clear();
      this.todoItemids = [];
      this.todoItems = []; //초기화 시켜주는게 필요.
    } //clearTodo

  } //methods

} //default
console.log(this);
</script>

<style>
input {
  border-style: groove;
  width: 200px;
}

button {
  border-style: groove;
}

.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03)
    /*상 우 하
    좌  css 공통*/
}

body {
  text-align: center;
  background-color: #F6F6F8;
}
</style>
