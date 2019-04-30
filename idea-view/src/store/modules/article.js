import * as types from '../mutation-types'


const state = {
  article: {},
  updateArticle:{},
};

const mutations = {
  [types.GET_ARTICLE](state,article){
    state.article = article;
  },
  [types.UPDATE_ARTICLE](state,article){
    state.updateArticle = article;
  }
};

const getters = {
  article : state => state.article,
  updateArticle : state => state.updateArticle
};
export default {
  state,
  getters,
  mutations
}

