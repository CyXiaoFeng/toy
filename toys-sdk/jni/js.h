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
const string CONST_JS = "javascript:window.webViewClient = {};"
	"var viewport = document.getElementsByName('viewport')[0];"
	"if (!viewport) {"
	"    viewport = document.createElement('META');"
	"    viewport.name = 'viewport';"
	"    document.getElementsByTagName('head')[0].appendChild(viewport);}"
	"viewport.content = 'width=device-width,user-scalable=no,minimum-scale=1,maximum-scale=1,initial-scale=1';"
	"var scale = %f;"
	"var width = document.body.clientWidth * scale;"
	"scale = (width < 375 ? 0.8 : width < 414 ? 0.9 : 1) / scale;"
	"viewport.content = 'width=device-width,user-scalable=no,minimum-scale=' + scale + ',maximum-scale=' + scale + ',initial-scale=' + scale;"
	"window.webViewClient.check = function(){"
	"    var ary = 'init,start,pause,stop,restart,getScore,getScreenShot,setScreenShot'.split(',');"
	"    for (var i = 0; i < ary.length; i++){"
	"        var name = ary[i];"
	"       if (window[name])"
	"            continue;"
	"        requestAnimationFrame(window.webViewClient.check);"
	"        return; }"
	"    window._stop = window.stop;"
	"    window.stop = function()    {"
	"        %@(null);"
	"        window._stop();"
	"        window.gameOver = 1; };"
	"    window.webViewClient.pullScreenShot = function()    {"
	"        var tmp = window.getScreenShot() || '';"
	"        var str = '{';"
	"        str += 'g:' + window.gameOver + ',';"
	"        str += 's:' + window.getScore() + ',';"
	"        str += 'd:' + tmp + '}';"
	"        %@(str);};"
	"    window.sendData = function(str)    {"
	"        %@(str);    };"
	"    window.webViewClient.receiveData = window.receiveData || function(){};"
	"    window.createAudio = function(arg){"
	"        if (typeof arg == 'string')"
	"            arg = {src:arg};"
	"        var audio = {};"
	"        for ( var attr in arg)"
	"            audio[attr] = arg[attr];"
	"        audio.play = function(num){"
	"            if (num == undefined)"
	"                num = this.loop ? -1 : 1;"
	"            %@(this.src + ',' + num); };"
	"        audio.pause = function(){"
	"            this.stop(); };"
	"        audio.stop = function(){        };"
	"        if (arg.autoplay)"
	"            audio.play();"
	"        return audio; };"
	"    window.init();"
	"    %@(null);}; window.webViewClient.check();";
#endif /* JS_H_ */
