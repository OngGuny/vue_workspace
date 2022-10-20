<template lang="html">
<section>
<transition-group name="list" tag="ul">
    <li v-for="(todoItem,index) in propsdata" :key="todoItem" class="shadow">
      <i class="checkBtn fas fa-check" aria-hidden="true"></i>
      {{todoItem}}
      <span class="removeBtn" type="button" @click="removeTodo(todoItem,index,propsid[index])">
        <i class="far fa-trash-alt" aria-hidden="true"></i>
      </span>
    </li>
</transition-group>
</section>

</template>

<script>
export default {

  // data(){ app.vue 로 옮겨갔기 떄문에 없에줌
  //   return{
  //     todoItems:[]
  //   }
  // },
  //created 도 app.vue으로 간다.
  // created(){
  //   let storageLength= localStorage.length; //계속 연산자를 호출 하기보단 담아서 뿌림 객체뽀개ㅔ기
  //   if(storageLength>0){
  //     for(let i=0; i<storageLength; i++){
  //       this.todoItems.push(localStorage.key(i));
  //       /*<-pop    배열에 담기는 순서     <- push*/
  //     }//for
  //   }//if
  // },
  //상위컴포넌트에게 데이터 넘겨주려면 에밋으로 이벤트 발생시키면서 값을 넘긴다는것.  리무브 투두 이벤트발생+데이터전달
  props: ['propsdata','propsid'],
  methods: {
    removeTodo(todoItem, index ,todoItemids) {
      console.log(todoItemids)
      this.$emit("removeTodo", todoItem,index, todoItemids);
      // localStorage.removeItem(todoItem);
      // this.todoItems.splice(index,1);
    }
  }

} //default
</script>

<style>
ul {
  list-style-type: none;
  /*앞의 점 모양이 사라짐*/
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 10px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 10px;
}

.removeBtn {
  margin-left: auto;
  coloer: #62acde;
}

.list-enter-active, .list-leave-active{
  transition:all 1s;
}

.list-enter, .list-leave-to{
  opacity:0;
  transform:translateY(30px);
}
</style>
