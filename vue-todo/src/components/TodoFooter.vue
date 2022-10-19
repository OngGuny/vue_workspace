<template lang="html">
<div class="clearAllContainer">
<span class="clearAllBtn" @click="clearTodo">ClearAll</span>
</div>
</template>

<script>
export default {
  //얘네도 app.vue로 간다.
  methods:{
    clearTodo(){
      //localStorage.clear();
      this.$emit("removeAll");
    }
  }

}
</script>

<style lang="css" scoped>
.clearAllContainer{
  width:8.5rem;
  height: 50px;
  line-height:50px;
  background-color: white;
  border-radius: 10px;
  margin: 0 auto;
}

.clearAllBtn{
  color:#e20303;
  display: black;
}
</style>
