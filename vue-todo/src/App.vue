<template>
<div id="app">
  <TodoHeader></TodoHeader>
  <TodoInput v-on:addTodo="addTodo"></TodoInput>
  <TodoList v-bind:propsdata="todoItems" @removeTodo="removeTodo"></TodoList>
  <TodoFooter v-on:removeAll="clearAll"></TodoFooter>

</div>
</template>
<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoFooter from './components/TodoFooter.vue'
import TodoList from './components/TodoList.vue'
import TodoInput from './components/TodoInput.vue'
export default {
  //data() List에 있던거 가져옴 이제 app.vue 에서 관리하겠다는거.

  data() {
    return {
      todoItems:[]
    }
  },
  //list 에 있던거 들고옴
  created() {
    let storageLength = localStorage.length; //계속 연산자를 호출 하기보단 담아서 뿌림 객체뽀개ㅔ기
    if (storageLength > 0) {
      for (let i = 0; i<storageLength; i++) {
        this.todoItems.push(localStorage.key(i));
        /*<-pop    배열에 담기는 순서     <- push*/
      } //for
    } //if
  }, //created
  // input 에 있던거 들고옴 addtodo 라는 이벤트 추가

  components: {
    'TodoHeader': TodoHeader,
    'TodoInput': TodoInput,
    'TodoFooter': TodoFooter,
    'TodoList': TodoList
  }, //components

  methods: {
    addTodo(todoItem) {
      localStorage.setItem(todoItem, todoItem);
      this.todoItems.push(todoItem);
    }, //addTodo

    removeTodo(todoItem, index) {
      localStorage.removeItem(todoItem);
      this.todoItems.splice(index, 1);
    }, //removeTodo

    //footer 에 있떤거 들고옴
    clearAll() {
      localStorage.clear();
      this.todoItems=[]; //초기화 시켜주는게 필요.
    } //clearTodo

  } //methods

} //default
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
    /*상 우 하 좌  css 공통*/
}

body {
  text-align: center;
  background-color: #F6F6F8;
}
</style>
