/*
 * js.h
 *
 *  Created on: 2017Äê2ÔÂ16ÈÕ
 *      Author: EW
 */
#include <string>
using namespace std;
#ifndef JS_H_
#define JS_H_
const string CONST_JS = "window.webViewClient={};var viewport=document.getElementsByName(\"viewport\")[0];viewport||(viewport=document.createElement(\"META\"),viewport.name=\"viewport\",document.getElementsByTagName(\"head\")[0].appendChild(viewport)),viewport.content=\"width=device-width,user-scalable=no,minimum-scale=1,maximum-scale=1,initial-scale=1\";var scale=%f,width=document.body.clientWidth*scale;scale=(375>width?.8:414>width?.9:1)/scale,viewport.content=\"width=device-width,user-scalable=no,minimum-scale=\"+scale+\",maximum-scale=\"+scale+\",initial-scale=\"+scale,window.webViewClient.check=function(){for(var e=\"init,start,pause,stop,restart,getScore,getScreenShot,setScreenShot\".split(\",\"),i=0;i<e.length;i++){var t=e[i];if(!window[t])return void requestAnimationFrame(window.webViewClient.check)}window._stop=window.stop,window.stop=function(){%@(null),window._stop(),window.gameOver=1},window.webViewClient.pullScreenShot=function(){var e=window.getScreenShot()||\"\",i=\"{\";i+=\"g:\"+window.gameOver+\",\",i+=\"s:\"+window.getScore()+\",\",i+=\"d:\"+e+\"}\",%@(i)},window.sendData=function(e){%@(e)},window.webViewClient.onReceiveData=window.onReceiveData||function(){},window.createAudio=function(e){\"string\"==typeof e&&(e={src:e});var i={};for(var t in e)i[t]=e[t];return i.play=function(e){void 0==e&&(e=this.loop?-1:1),%@(this.src+\",\"+e)},i.pause=function(){this.stop()},i.stop=function(){},e.autoplay&&i.play(),i},window.init(),%@(null)},window.webViewClient.check();";
#endif /* JS_H_ */
