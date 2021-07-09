package client;

public class class103 extends class105 {
   int field1366;
   int field1356;
   int field1359;
   int field1362;
   int field1355;
   int field1364;
   int field1357;
   int field1360;
   int field1363;
   int field1361;
   int field1367;
   int field1358;
   int field1368;
   boolean field1365;
   int field1369;

   class103(class93 var1, int var2, int var3, int var4) {
      super.field1383 = var1;
      this.field1363 = var1.field1277;
      this.field1367 = var1.field1280;
      this.field1365 = var1.field1281;
      this.field1364 = var2;
      this.field1356 = var3;
      this.field1366 = var4;
      this.field1357 = 0;
      this.method2324();
   }

   class103(class93 var1, int var2, int var3) {
      super.field1383 = var1;
      this.field1363 = var1.field1277;
      this.field1367 = var1.field1280;
      this.field1365 = var1.field1281;
      this.field1364 = var2;
      this.field1356 = var3;
      this.field1366 = 8192;
      this.field1357 = 0;
      this.method2324();
   }

   public synchronized int method2263() {
      return this.field1366 < 0 ? -1 : this.field1366;
   }

   synchronized void method2260(int var1) {
      this.method2261(var1, this.method2263());
   }

   synchronized void method2261(int var1, int var2) {
      this.field1356 = var1;
      this.field1366 = var2;
      this.field1355 = 0;
      this.method2324();
   }

   public synchronized void method2268(int var1, int var2, int var3) {
      if(var1 == 0) {
         this.method2261(var2, var3);
      } else {
         int var4 = method2341(var2, var3);
         int var5 = method2251(var2, var3);
         if(var4 == this.field1360 && var5 == this.field1361) {
            this.field1355 = 0;
         } else {
            int var6 = var2 - this.field1359;
            if(this.field1359 - var2 > var6) {
               var6 = this.field1359 - var2;
            }

            if(var4 - this.field1360 > var6) {
               var6 = var4 - this.field1360;
            }

            if(this.field1360 - var4 > var6) {
               var6 = this.field1360 - var4;
            }

            if(var5 - this.field1361 > var6) {
               var6 = var5 - this.field1361;
            }

            if(this.field1361 - var5 > var6) {
               var6 = this.field1361 - var5;
            }

            if(var1 > var6) {
               var1 = var6;
            }

            this.field1355 = var1;
            this.field1356 = var2;
            this.field1366 = var3;
            this.field1358 = (var2 - this.field1359) / var1;
            this.field1368 = (var4 - this.field1360) / var1;
            this.field1369 = (var5 - this.field1361) / var1;
         }
      }
   }

   public synchronized void vmethod4385(int[] var1, int var2, int var3) {
      if(this.field1356 == 0 && this.field1355 == 0) {
         this.vmethod4386(var3);
      } else {
         class93 var4 = (class93)super.field1383;
         int var5 = this.field1363 << 8;
         int var6 = this.field1367 << 8;
         int var7 = var4.field1278.length << 8;
         int var8 = var6 - var5;
         if(var8 <= 0) {
            this.field1362 = 0;
         }

         int var9 = var2;
         var3 += var2;
         if(this.field1357 < 0) {
            if(this.field1364 <= 0) {
               this.method2266();
               this.unlink();
               return;
            }

            this.field1357 = 0;
         }

         if(this.field1357 >= var7) {
            if(this.field1364 >= 0) {
               this.method2266();
               this.unlink();
               return;
            }

            this.field1357 = var7 - 1;
         }

         if(this.field1362 < 0) {
            if(this.field1365) {
               if(this.field1364 < 0) {
                  var9 = this.method2280(var1, var2, var5, var3, var4.field1278[this.field1363]);
                  if(this.field1357 >= var5) {
                     return;
                  }

                  this.field1357 = var5 + var5 - 1 - this.field1357;
                  this.field1364 = -this.field1364;
               }

               while(true) {
                  var9 = this.method2402(var1, var9, var6, var3, var4.field1278[this.field1367 - 1]);
                  if(this.field1357 < var6) {
                     return;
                  }

                  this.field1357 = var6 + var6 - 1 - this.field1357;
                  this.field1364 = -this.field1364;
                  var9 = this.method2280(var1, var9, var5, var3, var4.field1278[this.field1363]);
                  if(this.field1357 >= var5) {
                     return;
                  }

                  this.field1357 = var5 + var5 - 1 - this.field1357;
                  this.field1364 = -this.field1364;
               }
            } else if(this.field1364 < 0) {
               while(true) {
                  var9 = this.method2280(var1, var9, var5, var3, var4.field1278[this.field1367 - 1]);
                  if(this.field1357 >= var5) {
                     return;
                  }

                  this.field1357 = var6 - 1 - (var6 - 1 - this.field1357) % var8;
               }
            } else {
               while(true) {
                  var9 = this.method2402(var1, var9, var6, var3, var4.field1278[this.field1363]);
                  if(this.field1357 < var6) {
                     return;
                  }

                  this.field1357 = var5 + (this.field1357 - var5) % var8;
               }
            }
         } else {
            if(this.field1362 > 0) {
               if(this.field1365) {
                  label139: {
                     if(this.field1364 < 0) {
                        var9 = this.method2280(var1, var2, var5, var3, var4.field1278[this.field1363]);
                        if(this.field1357 >= var5) {
                           return;
                        }

                        this.field1357 = var5 + var5 - 1 - this.field1357;
                        this.field1364 = -this.field1364;
                        if(--this.field1362 == 0) {
                           break label139;
                        }
                     }

                     do {
                        var9 = this.method2402(var1, var9, var6, var3, var4.field1278[this.field1367 - 1]);
                        if(this.field1357 < var6) {
                           return;
                        }

                        this.field1357 = var6 + var6 - 1 - this.field1357;
                        this.field1364 = -this.field1364;
                        if(--this.field1362 == 0) {
                           break;
                        }

                        var9 = this.method2280(var1, var9, var5, var3, var4.field1278[this.field1363]);
                        if(this.field1357 >= var5) {
                           return;
                        }

                        this.field1357 = var5 + var5 - 1 - this.field1357;
                        this.field1364 = -this.field1364;
                     } while(--this.field1362 != 0);
                  }
               } else {
                  int var10;
                  if(this.field1364 < 0) {
                     while(true) {
                        var9 = this.method2280(var1, var9, var5, var3, var4.field1278[this.field1367 - 1]);
                        if(this.field1357 >= var5) {
                           return;
                        }

                        var10 = (var6 - 1 - this.field1357) / var8;
                        if(var10 >= this.field1362) {
                           this.field1357 += var8 * this.field1362;
                           this.field1362 = 0;
                           break;
                        }

                        this.field1357 += var8 * var10;
                        this.field1362 -= var10;
                     }
                  } else {
                     while(true) {
                        var9 = this.method2402(var1, var9, var6, var3, var4.field1278[this.field1363]);
                        if(this.field1357 < var6) {
                           return;
                        }

                        var10 = (this.field1357 - var5) / var8;
                        if(var10 >= this.field1362) {
                           this.field1357 -= var8 * this.field1362;
                           this.field1362 = 0;
                           break;
                        }

                        this.field1357 -= var8 * var10;
                        this.field1362 -= var10;
                     }
                  }
               }
            }

            if(this.field1364 < 0) {
               this.method2280(var1, var9, 0, var3, 0);
               if(this.field1357 < 0) {
                  this.field1357 = -1;
                  this.method2266();
                  this.unlink();
               }
            } else {
               this.method2402(var1, var9, var7, var3, 0);
               if(this.field1357 >= var7) {
                  this.field1357 = var7;
                  this.method2266();
                  this.unlink();
               }
            }

         }
      }
   }

   public synchronized void vmethod4386(int var1) {
      if(this.field1355 > 0) {
         if(var1 >= this.field1355) {
            if(this.field1356 == Integer.MIN_VALUE) {
               this.field1356 = 0;
               this.field1361 = 0;
               this.field1360 = 0;
               this.field1359 = 0;
               this.unlink();
               var1 = this.field1355;
            }

            this.field1355 = 0;
            this.method2324();
         } else {
            this.field1359 += this.field1358 * var1;
            this.field1360 += this.field1368 * var1;
            this.field1361 += this.field1369 * var1;
            this.field1355 -= var1;
         }
      }

      class93 var2 = (class93)super.field1383;
      int var3 = this.field1363 << 8;
      int var4 = this.field1367 << 8;
      int var5 = var2.field1278.length << 8;
      int var6 = var4 - var3;
      if(var6 <= 0) {
         this.field1362 = 0;
      }

      if(this.field1357 < 0) {
         if(this.field1364 <= 0) {
            this.method2266();
            this.unlink();
            return;
         }

         this.field1357 = 0;
      }

      if(this.field1357 >= var5) {
         if(this.field1364 >= 0) {
            this.method2266();
            this.unlink();
            return;
         }

         this.field1357 = var5 - 1;
      }

      this.field1357 += this.field1364 * var1;
      if(this.field1362 < 0) {
         if(!this.field1365) {
            if(this.field1364 < 0) {
               if(this.field1357 >= var3) {
                  return;
               }

               this.field1357 = var4 - 1 - (var4 - 1 - this.field1357) % var6;
            } else {
               if(this.field1357 < var4) {
                  return;
               }

               this.field1357 = var3 + (this.field1357 - var3) % var6;
            }

         } else {
            if(this.field1364 < 0) {
               if(this.field1357 >= var3) {
                  return;
               }

               this.field1357 = var3 + var3 - 1 - this.field1357;
               this.field1364 = -this.field1364;
            }

            while(this.field1357 >= var4) {
               this.field1357 = var4 + var4 - 1 - this.field1357;
               this.field1364 = -this.field1364;
               if(this.field1357 >= var3) {
                  return;
               }

               this.field1357 = var3 + var3 - 1 - this.field1357;
               this.field1364 = -this.field1364;
            }

         }
      } else {
         if(this.field1362 > 0) {
            if(this.field1365) {
               label123: {
                  if(this.field1364 < 0) {
                     if(this.field1357 >= var3) {
                        return;
                     }

                     this.field1357 = var3 + var3 - 1 - this.field1357;
                     this.field1364 = -this.field1364;
                     if(--this.field1362 == 0) {
                        break label123;
                     }
                  }

                  do {
                     if(this.field1357 < var4) {
                        return;
                     }

                     this.field1357 = var4 + var4 - 1 - this.field1357;
                     this.field1364 = -this.field1364;
                     if(--this.field1362 == 0) {
                        break;
                     }

                     if(this.field1357 >= var3) {
                        return;
                     }

                     this.field1357 = var3 + var3 - 1 - this.field1357;
                     this.field1364 = -this.field1364;
                  } while(--this.field1362 != 0);
               }
            } else {
               label155: {
                  int var7;
                  if(this.field1364 < 0) {
                     if(this.field1357 >= var3) {
                        return;
                     }

                     var7 = (var4 - 1 - this.field1357) / var6;
                     if(var7 >= this.field1362) {
                        this.field1357 += var6 * this.field1362;
                        this.field1362 = 0;
                        break label155;
                     }

                     this.field1357 += var6 * var7;
                     this.field1362 -= var7;
                  } else {
                     if(this.field1357 < var4) {
                        return;
                     }

                     var7 = (this.field1357 - var3) / var6;
                     if(var7 >= this.field1362) {
                        this.field1357 -= var6 * this.field1362;
                        this.field1362 = 0;
                        break label155;
                     }

                     this.field1357 -= var6 * var7;
                     this.field1362 -= var7;
                  }

                  return;
               }
            }
         }

         if(this.field1364 < 0) {
            if(this.field1357 < 0) {
               this.field1357 = -1;
               this.method2266();
               this.unlink();
            }
         } else if(this.field1357 >= var5) {
            this.field1357 = var5;
            this.method2266();
            this.unlink();
         }

      }
   }

   void method2324() {
      this.field1359 = this.field1356;
      this.field1360 = method2341(this.field1356, this.field1366);
      this.field1361 = method2251(this.field1356, this.field1366);
   }

   public synchronized void method2264(int var1) {
      int var2 = ((class93)super.field1383).field1278.length << 8;
      if(var1 < -1) {
         var1 = -1;
      }

      if(var1 > var2) {
         var1 = var2;
      }

      this.field1357 = var1;
   }

   protected class105 vmethod4389() {
      return null;
   }

   public boolean method2272() {
      return this.field1357 < 0 || this.field1357 >= ((class93)super.field1383).field1278.length << 8;
   }

   public synchronized void method2270(int var1) {
      if(this.field1364 < 0) {
         this.field1364 = -var1;
      } else {
         this.field1364 = var1;
      }

   }

   public synchronized void method2269(int var1) {
      if(var1 == 0) {
         this.method2260(0);
         this.unlink();
      } else if(this.field1360 == 0 && this.field1361 == 0) {
         this.field1355 = 0;
         this.field1356 = 0;
         this.field1359 = 0;
         this.unlink();
      } else {
         int var2 = -this.field1359;
         if(this.field1359 > var2) {
            var2 = this.field1359;
         }

         if(-this.field1360 > var2) {
            var2 = -this.field1360;
         }

         if(this.field1360 > var2) {
            var2 = this.field1360;
         }

         if(-this.field1361 > var2) {
            var2 = -this.field1361;
         }

         if(this.field1361 > var2) {
            var2 = this.field1361;
         }

         if(var1 > var2) {
            var1 = var2;
         }

         this.field1355 = var1;
         this.field1356 = Integer.MIN_VALUE;
         this.field1358 = -this.field1359 / var1;
         this.field1368 = -this.field1360 / var1;
         this.field1369 = -this.field1361 / var1;
      }
   }

   void method2266() {
      if(this.field1355 != 0) {
         if(this.field1356 == Integer.MIN_VALUE) {
            this.field1356 = 0;
         }

         this.field1355 = 0;
         this.method2324();
      }

   }

   public boolean method2273() {
      return this.field1355 != 0;
   }

   public synchronized void method2307(boolean var1) {
      this.field1364 = (this.field1364 ^ this.field1364 >> 31) + (this.field1364 >>> 31);
      if(var1) {
         this.field1364 = -this.field1364;
      }

   }

   protected class105 vmethod4382() {
      return null;
   }

   int vmethod2435() {
      int var1 = this.field1359 * 3 >> 6;
      var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
      if(this.field1362 == 0) {
         var1 -= var1 * this.field1357 / (((class93)super.field1383).field1278.length << 8);
      } else if(this.field1362 >= 0) {
         var1 -= var1 * this.field1363 / ((class93)super.field1383).field1278.length;
      }

      return var1 > 255 ? 255 : var1;
   }

   public synchronized int method2351() {
      return this.field1364 < 0 ? -this.field1364 : this.field1364;
   }

   boolean method2281() {
      int var1 = this.field1356;
      int var2;
      int var3;
      if(var1 == Integer.MIN_VALUE) {
         var3 = 0;
         var2 = 0;
         var1 = 0;
      } else {
         var2 = method2341(var1, this.field1366);
         var3 = method2251(var1, this.field1366);
      }

      if(var1 == this.field1359 && var2 == this.field1360 && var3 == this.field1361) {
         if(this.field1356 == Integer.MIN_VALUE) {
            this.field1356 = 0;
            this.field1361 = 0;
            this.field1360 = 0;
            this.field1359 = 0;
            this.unlink();
            return true;
         } else {
            this.method2324();
            return false;
         }
      } else {
         if(this.field1359 < var1) {
            this.field1358 = 1;
            this.field1355 = var1 - this.field1359;
         } else if(this.field1359 > var1) {
            this.field1358 = -1;
            this.field1355 = this.field1359 - var1;
         } else {
            this.field1358 = 0;
         }

         if(this.field1360 < var2) {
            this.field1368 = 1;
            if(this.field1355 == 0 || this.field1355 > var2 - this.field1360) {
               this.field1355 = var2 - this.field1360;
            }
         } else if(this.field1360 > var2) {
            this.field1368 = -1;
            if(this.field1355 == 0 || this.field1355 > this.field1360 - var2) {
               this.field1355 = this.field1360 - var2;
            }
         } else {
            this.field1368 = 0;
         }

         if(this.field1361 < var3) {
            this.field1369 = 1;
            if(this.field1355 == 0 || this.field1355 > var3 - this.field1361) {
               this.field1355 = var3 - this.field1361;
            }
         } else if(this.field1361 > var3) {
            this.field1369 = -1;
            if(this.field1355 == 0 || this.field1355 > this.field1361 - var3) {
               this.field1355 = this.field1361 - var3;
            }
         } else {
            this.field1369 = 0;
         }

         return false;
      }
   }

   int method2402(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1355 > 0) {
            int var6 = var2 + this.field1355;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1355 += var2;
            if(this.field1364 == 256 && (this.field1357 & 255) == 0) {
               if(class95.field1295) {
                  var2 = method2288(0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, this.field1368, this.field1369, 0, var6, var3, this);
               } else {
                  var2 = method2417(((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, this.field1358, 0, var6, var3, this);
               }
            } else if(class95.field1295) {
               var2 = method2295(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, this.field1368, this.field1369, 0, var6, var3, this, this.field1364, var5);
            } else {
               var2 = method2294(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, this.field1358, 0, var6, var3, this, this.field1364, var5);
            }

            this.field1355 -= var2;
            if(this.field1355 != 0) {
               return var2;
            }

            if(!this.method2281()) {
               continue;
            }

            return var4;
         }

         if(this.field1364 == 256 && (this.field1357 & 255) == 0) {
            if(class95.field1295) {
               return method2283(0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, 0, var4, var3, this);
            }

            return method2275(((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, 0, var4, var3, this);
         }

         if(class95.field1295) {
            return method2302(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, 0, var4, var3, this, this.field1364, var5);
         }

         return method2286(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, 0, var4, var3, this, this.field1364, var5);
      }
   }

   int method2280(int[] var1, int var2, int var3, int var4, int var5) {
      while(true) {
         if(this.field1355 > 0) {
            int var6 = var2 + this.field1355;
            if(var6 > var4) {
               var6 = var4;
            }

            this.field1355 += var2;
            if(this.field1364 == -256 && (this.field1357 & 255) == 0) {
               if(class95.field1295) {
                  var2 = method2293(0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, this.field1368, this.field1369, 0, var6, var3, this);
               } else {
                  var2 = method2328(((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, this.field1358, 0, var6, var3, this);
               }
            } else if(class95.field1295) {
               var2 = method2360(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, this.field1368, this.field1369, 0, var6, var3, this, this.field1364, var5);
            } else {
               var2 = method2271(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, this.field1358, 0, var6, var3, this, this.field1364, var5);
            }

            this.field1355 -= var2;
            if(this.field1355 != 0) {
               return var2;
            }

            if(!this.method2281()) {
               continue;
            }

            return var4;
         }

         if(this.field1364 == -256 && (this.field1357 & 255) == 0) {
            if(class95.field1295) {
               return method2274(0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, 0, var4, var3, this);
            }

            return method2374(((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, 0, var4, var3, this);
         }

         if(class95.field1295) {
            return method2289(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1360, this.field1361, 0, var4, var3, this, this.field1364, var5);
         }

         return method2362(0, 0, ((class93)super.field1383).field1278, var1, this.field1357, var2, this.field1359, 0, var4, var3, this, this.field1364, var5);
      }
   }

   public synchronized int method2262() {
      return this.field1356 == Integer.MIN_VALUE ? 0 : this.field1356;
   }

   public synchronized void method2258(int var1) {
      this.field1362 = var1;
   }

   protected int vmethod4395() {
      return this.field1356 == 0 && this.field1355 == 0 ? 0 : 1;
   }

   public synchronized void method2408(int var1, int var2) {
      this.method2268(var1, var2, this.method2263());
   }

   public synchronized void method2267(int var1) {
      this.method2261(var1 << 6, this.method2263());
   }

   static int method2341(int var0, int var1) {
      return var1 < 0 ? var0 : (int)((double)var0 * Math.sqrt((double)(16384 - var1) * 1.220703125E-4D) + 0.5D);
   }

   static int method2251(int var0, int var1) {
      return var1 < 0 ? -var0 : (int)((double)var0 * Math.sqrt((double)var1 * 1.220703125E-4D) + 0.5D);
   }

   static int method2286(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
         var7 = var8;
      }

      byte var13;
      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         var13 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
         var7 = var8;
      }

      for(var1 = var12; var5 < var7; var4 += var11) {
         var13 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1357 = var4;
      return var5;
   }

   static int method2362(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10, int var11, int var12) {
      if(var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
         var7 = var8;
      }

      int var10001;
      while(var5 < var7) {
         var1 = var4 >> 8;
         byte var13 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
         var4 += var11;
      }

      if(var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
         var7 = var8;
      }

      var0 = var12;

      for(var1 = var11; var5 < var7; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
      }

      var10.field1357 = var4;
      return var5;
   }

   static int method2275(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class103 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var7 - var2) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
         var10001 = var3++;
      }

      var8.field1357 = var2 << 8;
      return var3;
   }

   static int method2302(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      byte var14;
      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1357 = var4;
      return var5 >> 1;
   }

   static int method2374(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, class103 var8) {
      var2 >>= 8;
      var7 >>= 8;
      var4 <<= 2;
      if((var5 = var3 + var2 - (var7 - 1)) > var6) {
         var5 = var6;
      }

      int var10001;
      for(var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var10001 = var3++;
      }

      for(var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
         var10001 = var3++;
      }

      var8.field1357 = var2 << 8;
      return var3;
   }

   static int method2289(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var5 <<= 1;

      int var10001;
      for(var8 <<= 1; var5 < var8; var4 += var12) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      if(var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var8 <<= 1;

      for(var1 = var13; var5 < var8; var4 += var12) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
      }

      var11.field1357 = var4;
      return var5 >> 1;
   }

   static int method2283(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var4 + var9 - var3) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1357 = var3 << 8;
      return var4 >> 1;
   }

   static int method2274(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, class103 var10) {
      var3 >>= 8;
      var9 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      if((var7 = var3 + var4 - (var9 - 1)) > var8) {
         var7 = var8;
      }

      var4 <<= 1;
      var7 <<= 1;

      int var10001;
      byte var11;
      for(var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
         var2[var10001] += var11 * var6;
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      for(var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
         var11 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var11 * var5;
         var10001 = var4++;
      }

      var10.field1357 = var3 << 8;
      return var4 >> 1;
   }

   static int method2294(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      var11.field1360 -= var11.field1368 * var5;
      var11.field1361 -= var11.field1369 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
         var8 = var9;
      }

      byte var14;
      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         var14 = var2[var1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
         var8 = var9;
      }

      for(var1 = var13; var5 < var8; var4 += var12) {
         var14 = var2[var4 >> 8];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1360 += var11.field1368 * var5;
      var11.field1361 += var11.field1369 * var5;
      var11.field1359 = var6;
      var11.field1357 = var4;
      return var5;
   }

   static int method2271(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, class103 var11, int var12, int var13) {
      var11.field1360 -= var11.field1368 * var5;
      var11.field1361 -= var11.field1369 * var5;
      if(var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      int var10001;
      while(var5 < var8) {
         var1 = var4 >> 8;
         byte var14 = var2[var1 - 1];
         var10001 = var5++;
         var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
         var4 += var12;
      }

      if(var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
         var8 = var9;
      }

      var0 = var13;

      for(var1 = var12; var5 < var8; var4 += var1) {
         var10001 = var5++;
         var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
         var6 += var7;
      }

      var11.field1360 += var11.field1368 * var5;
      var11.field1361 += var11.field1369 * var5;
      var11.field1359 = var6;
      var11.field1357 = var4;
      return var5;
   }

   static int method2417(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class103 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var8 - var2) > var7) {
         var6 = var7;
      }

      var9.field1360 += var9.field1368 * (var6 - var3);
      var9.field1361 += var9.field1369 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2++] * var4;
      }

      var9.field1359 = var4 >> 2;
      var9.field1357 = var2 << 8;
      return var3;
   }

   static int method2328(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, class103 var9) {
      var2 >>= 8;
      var8 >>= 8;
      var4 <<= 2;
      var5 <<= 2;
      if((var6 = var3 + var2 - (var8 - 1)) > var7) {
         var6 = var7;
      }

      var9.field1360 += var9.field1368 * (var6 - var3);
      var9.field1361 += var9.field1369 * (var6 - var3);

      int var10001;
      for(var6 -= 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
         var4 += var5;
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      for(var6 += 3; var3 < var6; var4 += var5) {
         var10001 = var3++;
         var1[var10001] += var0[var2--] * var4;
      }

      var9.field1359 = var4 >> 2;
      var9.field1357 = var2 << 8;
      return var3;
   }

   static int method2295(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class103 var13, int var14, int var15) {
      var13.field1359 -= var5 * var13.field1358;
      if(var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      byte var16;
      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         var16 = var2[var1];
         var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var16 = var2[var4 >> 8];
         var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1359 += var13.field1358 * var5;
      var13.field1360 = var6;
      var13.field1361 = var7;
      var13.field1357 = var4;
      return var5;
   }

   static int method2360(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, class103 var13, int var14, int var15) {
      var13.field1359 -= var5 * var13.field1358;
      if(var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var5 <<= 1;

      int var10001;
      for(var10 <<= 1; var5 < var10; var4 += var14) {
         var1 = var4 >> 8;
         byte var16 = var2[var1 - 1];
         var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      if(var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
         var10 = var11;
      }

      var10 <<= 1;

      for(var1 = var15; var5 < var10; var4 += var14) {
         var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
         var10001 = var5++;
         var3[var10001] += var0 * var6 >> 6;
         var6 += var8;
         var10001 = var5++;
         var3[var10001] += var0 * var7 >> 6;
         var7 += var9;
      }

      var5 >>= 1;
      var13.field1359 += var13.field1358 * var5;
      var13.field1360 = var6;
      var13.field1361 = var7;
      var13.field1357 = var4;
      return var5;
   }

   static int method2288(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class103 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var11 + var4 - var3) > var10) {
         var9 = var10;
      }

      var12.field1359 += var12.field1358 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3++];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1360 = var5 >> 2;
      var12.field1361 = var6 >> 2;
      var12.field1357 = var3 << 8;
      return var4 >> 1;
   }

   static int method2293(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, class103 var12) {
      var3 >>= 8;
      var11 >>= 8;
      var5 <<= 2;
      var6 <<= 2;
      var7 <<= 2;
      var8 <<= 2;
      if((var9 = var3 + var4 - (var11 - 1)) > var10) {
         var9 = var10;
      }

      var12.field1359 += var12.field1358 * (var9 - var4);
      var4 <<= 1;
      var9 <<= 1;

      byte var13;
      int var10001;
      for(var9 -= 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
         var6 += var8;
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      for(var9 += 6; var4 < var9; var6 += var8) {
         var13 = var1[var3--];
         var10001 = var4++;
         var2[var10001] += var13 * var5;
         var5 += var7;
         var10001 = var4++;
         var2[var10001] += var13 * var6;
      }

      var12.field1360 = var5 >> 2;
      var12.field1361 = var6 >> 2;
      var12.field1357 = var3 << 8;
      return var4 >> 1;
   }

   public static class103 method2256(class93 var0, int var1, int var2, int var3) {
      return var0.field1278 != null && var0.field1278.length != 0 ? new class103(var0, var1, var2, var3) : null;
   }

   public static class103 method2287(class93 var0, int var1, int var2) {
      return var0.field1278 != null && var0.field1278.length != 0 ? new class103(var0, (int)((long)var0.field1279 * 256L * (long)var1 / (long)(class95.field1300 * 100)), var2 << 6) : null;
   }
}
