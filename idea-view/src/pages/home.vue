<template>
  <div class="homepage">
    <div class="home-main-right">

      <div class="homepageCarousel" @mouseover="clearTimer()" @mouseout="selfAdd()">
        <div class="carouselshow">
          <transition-group tag="ul" name="carousel">
            <li v-for="(carousel,index) in carouselInfo.data" :key="index" v-show="mark === index">
              <a href="#"><img :src="carousel.path"/></a>
            </li>
          </transition-group>
        </div>
        <div class="carousel-bar">
          <span v-for="(item,index) in carouselInfo.data" :key="index" :class="{active: mark === index}"
                @click="changeMark(index)"></span>
        </div>
      </div>

      <div class="hots">
        <h3>广播</h3>
        <div style="height: 1px"></div>
        <a class="hot" @click="viewMore(radio.name, radio.id)" v-for="radio in radios.data">
          <img :src="radio.cover" alt=""><span class="name" v-text="radio.name"></span>
        </a>
      </div>
      <div class="split-line"></div>
    </div>
    <div class="home-main-left">
      <a href="javascript:;" id="download-qrcode">
        <img src="../assets/img/qrcode.png" alt="" class="qrcode">
        <div class="info">
          <div class="title" @click="getArticleList">下载 IDEA 手机App<i class="iconfont ic-link"></i></div>
          <div class="description">随时随地发现和发布想法</div>
        </div>
      </a>
      <recommended-author></recommended-author>
    </div>
  </div>
</template>

<script>
  import {mapState} from 'vuex'
  import recommendedAuthor from '../components/recommendedAuthor'
  import ArticleList from './../pages/article/articleList'
  import {Message, MessageBox} from 'element-ui'

  export default {
    components: {
      recommendedAuthor,
      ArticleList
    },
    computed: {
      ...mapState({
        // articles: state => state.Author.authorInformation[0].articleLists.hots
      })
    },
    data() {
      return {
        dfsPath: "http://192.168.198.130:8888/",
        timer: null,
        mark: 0,  //比对图片索引的变量
        carouselImg: [
          require('../assets/img/carousel1.jpg'),
          require('../assets/img/carousel2.jpg'),
          require('../assets/img/carousel3.jpg')
        ],
        carouselInfo: null,
        radios: null,
        articles:{
          rows:[],
          offset:0,
          limit:20,
        },
        moreButton: true,
        moreButtonLoading: false,
      }
    },
    mounted() {
      //this.getArticleList();
      this.getCarousel();
      this.getRadios();
    },
    methods: {
      getArticleList() {
        this.$axios.get('/getArticleList',{params:{offset:this.articles.offset,limit:this.articles.limit}}).then(res => {
          this.moreButtonLoading = false;
          if(res.rows.length < this.articles.limit){
            this.moreButton = false
          }
          if(res.rows.length > 0){
            this.articles.offset = this.articles.offset + res.count;
          }else{
            this.moreButton = false
            Message.success('已经没有更多新的信息了')
            return false;
          }
          this.articles.rows.push(...res.rows);
        }).catch(err => {
        })
      },
      getCarousel() {
        this.axios({
          method: 'get',
          url: 'http://localhost:8509/v1/page/contents/type/1'
        }).then((repos) => {
          this.carouselInfo=repos
        }).catch((error) => {
          this.carouselInfo=error;
          for (var i = 0; i < this.carouselInfo.data.length; i++) {
            this.carouselInfo.data[i].path = this.dfsPath + this.carouselInfo.data[i].path;
          }
        });
      },
      getRadios() {
        this.axios({
          method: 'get',
          url: 'http://localhost:8508/v1/radios/show'
        }).then((repos) => {
          this.radios=repos
        }).catch((error) => {
          this.radios=error;
          for (var i = 0; i < this.radios.data.length; i++) {
            this.radios.data[i].cover = this.dfsPath + this.radios.data[i].cover;
          }
          console.log(error);
        });
      },

      articleMore() {
        this.moreButtonLoading = true;
        setTimeout(()=>{
          this.getArticleList();
        },1000)

      },
      //自加1
      selfAdd() {
        var self = this;
        self.timer = setInterval(function () {
          self.mark++;
          if (self.mark === 3) {
            self.mark = 0;
          }
        }, 3500);
      },
      changeMark(index) {
        this.mark = index;
      },
      clearTimer() {
        clearInterval(this.timer);
      },
      viewMore(theme, id) {
        this.$store.dispatch('confirmAuthor', theme);
        this.$router.push('/author/' + id);
      }
    },
    created() {
      this.selfAdd();
    }
  }
</script>
<style scoped>

  .homepage {
    width: 1150px;
    margin: 0 auto;
    padding: 20px 0 180px 30px;
    box-sizing: border-box;
  }
  .home-main-left {
    padding-left: 80px;
    width: 360px;
    float: left;
  }
  .home-main-right {
    width: 680px;
    margin:0 0 0 38px;
    display: inline-block;
  }
  .homepage .homepageCarousel {
    border-radius: 6px;
    overflow: hidden;
    z-index: 1000;
    width: 615px;
    height: 270px;
    position: relative;
    border: 1px solid #eeeeee;
  }

  .homepage .homepageCarousel ul {
    overflow: hidden;
  }

  .homepage .homepageCarousel .carouselshow {
    width: 615px;
    height: 270px;
  }

  .homepage .homepageCarousel li {
    position: absolute;
  }

  .homepage .homepageCarousel img {
    width: 615px;
    height: 270px;
  }

  .homepage .homepageCarousel .carousel-bar {
    position: absolute;
    width: 100%;
    bottom: 10px;
    margin: 0 auto;
    z-index: 10;
    text-align: center;
  }

  .homepage .homepageCarousel .carousel-bar span {
    width: 20px;
    height: 5px;
    border: 1px solid hsla(0, 0%, 47%, .4);
    background-color: hsla(0, 0%, 47%, .4);
    display: inline-block;
    margin-right: 10px;
  }

  .homepage .homepageCarousel .active {
    background: white !important;
  }
  .more{
    width: 100%;
    padding: 30px 15px;
  }
  .more button{
    width: 100%;
  }
</style>
