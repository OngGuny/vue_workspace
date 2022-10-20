<template lang="html">
<div class="inputBox shadow">
<input type="text" v-model="newTodoItem" placeholder="할 일을 입력! 두!!"
v-on:keyup.enter="addTodo"><!--눌렀다가 뗄 때 키가 업. 엔터눌렀을때. -->
<vue-timepicker container-id fixed-dropdown-button v-model="newTodoTime" format="HH:mm" :minute-interval="5" auto-scroll drop-direction="auto" close-on-complete></vue-timepicker>
<span class="addContainer" v-on:click="addTodo">

<i class="addBtn fas fa-plus" aria-hidden="true"></i>
</span>
<modal v-if="showModal" @close="showModal=false">
   <h3 slot="header">경고↘ 경↗고~ </h3>
   <span slot="footer" @click="showModal=false">
     할 일과 시간을 같이 입력해주세요 <br/>시간은 00:00 형태로 입력해주세요
     <i class="closeModalBtn fas fa-times" aria-hidden="true"></i>
   </span>
</modal>

<!-- String form -->
</div>
</template>

<script>
import Modal from "./common/Modal.vue"
import VueTimepicker from 'vue2-timepicker/src/vue-timepicker.vue'

export default {
  components:{
    Modal:Modal,
    VueTimepicker
  },
  data() {
    return {
      newTodoItem: "" ,//초기 에는 null. 위의 템플릿이 시작되면 여기있는 데이터 주겠다는것.
      newTodoTime: "" ,
      showModal: false
    }


  },
  methods:{
    addTodo() {
      if (this.newTodoItem !== "" && this.newTodoTime!=="") {
        var todo = this.newTodoItem && this.newTodoItem.trim();
        var time = this.newTodoTime && this.newTodoTime.trim();
        this.$emit("addTodo",todo,time); // addTodo 이벤트 발생 후 value 값을 넘겨줌.
        //localStorage.setItem(value, value);위의 코드로 저장하는역할 넘겨줌, 여기서 관리하는게 아니라 app 에서 관리하겠다는거
        this.clearInput();
      }else{
        this.showModal = !this.showModal;
      }
    }, //addTodo
    clearInput() { //초기화
      this.newTodoItem = "";
      this.newTodoTime = "";
      console.log(document.getElementsByClassName("hours"));
      document.getElementsByClassName("hours");
      console.log(document.getElementsByClassName("minutes"));
    } // clearInput
  } //methods

}//default
</script>

<style lang="css" scoped>

input:focus{
  outline:none;
}
.inputBox{
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 10px;
}
.inputBox input{
  border-style: none;/*이거하면 보더가 안나온다.*/
  font-size: 0.9rem;
}
.addContainer{
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0 ;
}


</style>
