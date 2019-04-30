/**
 * Created by 12973 on 2018/8/8.
 */
import * as types from '../mutation-types'

const authors = [
  [{
    img:require('../../assets/img/editor11.jpg'),
    name:'C',
    description:'114.5k喜欢'
  },
    {
      img:require('../../assets/img/editor11.jpg'),
      name:'C++',
      description:'160.4k喜欢'
    },
    {
      img:require('../../assets/img/editor3.jpg'),
      name:'Java',
      description:'260.4k喜欢'
    },
    {
      img:require('../../assets/img/editor3.jpg'),
      name:'Go',
      description:'615喜欢'
    }],
  [{
    img:require('../../assets/img/editor11.jpg'),
    name:'Python',
    description:'15.5k喜欢'
  },
    {
      img:require('../../assets/img/editor2.jpg'),
      name:'JavaScript',
      description:'1.4k喜欢'
    },
    {
      img:require('../../assets/img/editor6.jpg'),
      name:'PHP',
      description:'2.6k喜欢'
    },
    {
      img:require('../../assets/img/editor2.jpg'),
      name:'Ruby',
      description:'615喜欢'
    }],
  [{
    img:require('../../assets/img/editor3.jpg'),
    name:'TypeScript',
    description:'1.5k喜欢'
  },
    {
      img:require('../../assets/img/editor2.jpg'),
      name:'Vue',
      description:'1.8k喜欢'
    },
    {
      img:require('../../assets/img/editor8.jpg'),
      name:'Spring',
      description:'260喜欢'
    },
    {
      img:require('../../assets/img/editor3.jpg'),
      name:'Spring MVC',
      description:'615喜欢'
    }],
  [{
    img:require('../../assets/img/editor11.jpg'),
    name:'Mybatis',
    description:'1.6k喜欢'
  },
    {
      img:require('../../assets/img/editor2.jpg'),
      name:'Spring Boot',
      description:'1.4k喜欢'
    },
    {
      img:require('../../assets/img/editor6.jpg'),
      name:'Spring Cloud',
      description:'265喜欢'
    },
    {
      img:require('../../assets/img/editor3.jpg'),
      name:'Docker',
      description:'2.6k喜欢'
    }]
];





let i= 0;
const state = {
  authors:authors[i]
};

const mutations = {
  [types.ANOTHER_AUTHORS](state){
    i === authors.length-1? i=0:i++;
    state.authors = authors[i];
  }
};


export default {
  state,
  mutations
}
