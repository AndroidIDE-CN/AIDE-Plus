package com.aide.ui.services;

import abcd.it;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import com.aide.engine.EngineSolution;
import com.aide.ui.App;
import com.aide.ui.firebase.FireBaseLogEvent;
import com.aide.ui.project.AndroidProjectSupport;
import com.aide.ui.project.internal.GradleTools;
import com.aide.ui.util.BuildGradle;
import com.google.android.gms.internal.measurement.k2;
import io.github.zeroaicy.aide.ui.services.ExecutorsService;
import io.github.zeroaicy.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import io.github.zeroaicy.aide.extend.ZeroAicyExtensionInterface;
import com.aide.ui.util.FileSystem;

public class ZeroAicyProjectService extends ProjectService {

	private static final String TAG = "ZeroAicyProjectService";

	private static ProjectService singleton;

	public static ProjectService getSingleton() {
		if (singleton == null) {
			singleton = new ZeroAicyProjectService();
			Log.d(TAG,  "ZeroAicyProjectService");
		}
		return singleton;
	}

	public ZeroAicyProjectService() {
		//OpenFileService mOpenFileService;
		//AIDEEditorPager.openFile("");
		this.FH = new ConcurrentHashMap<>();

		this.Hw = Collections.synchronizedList(new ArrayList<String>());

	}

	// 耗时任务 MavenService -> J8 [resolveFullDependencyTree]
	ExecutorsService executorsService = ExecutorsService.getExecutorsService();
	@Override
	protected void jJ() {
		// 空项目
		if (this.j6 == null 
			|| this.DW == null) {
			List emptyList = Collections.emptyList();
			final EngineSolution engineSolution = new EngineSolution(emptyList, null, com.aide.engine.service.l.j6(App.Hw()), App.Hw());
            if (ExecutorsService.isUiThread()) {
                App.we().er(engineSolution);
                App.we().ef();
                App.we().ei();
                return;
            }
            sendEngineSolution(engineSolution);
            return;
        }

		executorsService.submit(new Runnable(){
				@Override
				public void run() {

					ProjectSupport dW = ZeroAicyProjectService.this.DW;
					final EngineSolution engineSolution = dW.Ws();
					sendEngineSolution(engineSolution);
				}
			});
	}
	private void sendEngineSolution(final EngineSolution engineSolution) {
		App.aj(new Runnable(){
				@Override
				public void run() {
					App.we().er(engineSolution);
					App.we().ef();
					App.we().ei();
				}
			});
	}

	/*****************************************************************/

	@Override
	public void cb(final String string) {
		try {

			final ProgressDialog show = ProgressDialog.show(App.getMainActivity(), null, "Opening project...", true, false);
			show.getWindow().addFlags(128);
			show.getWindow().clearFlags(2);

			final Runnable dismissRunnable = new Runnable(){
				@Override
				public void run() {
					show.dismiss();
				}
			};
			executorsService.submit(new Runnable(){
					@Override
					public void run() {
						super_cb(string);
						App.aj(dismissRunnable);
					}
				});


		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}
	/*/
	 @Override
	 public void cb(final String string) {
	 super_cb(string);
	 }//*/
	public void super_cb(String str) {
		SharedPreferences sharedPreferences = App.getContext().getSharedPreferences("ProjectService", 0);
		if (!App.isTrainerMode() 
			&& App.getMainActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
			if (str != null) {
				FireBaseLogEvent.tp("App init: From intent");
				saveCurrentAppHome(SI(str));
			} else {
				String string = sharedPreferences.getString("CurrentAppHome", null);
				this.j6 = string;
				if (string != null && getProjectSupport(string) == null) {
					this.j6 = null;
				}
			}
		}

		this.DW = getProjectSupport(this.j6);

		Qq();

		if (ZeroAicyProjectService.this.DW != null) {
			App.getDebugger().P8(ZeroAicyProjectService.this.DW.yS(), true);
		}
		if (ZeroAicyProjectService.this.j6 != null) {
			FireBaseLogEvent.tp("App init: Opened existing project");
			et(null, false);
			sy("init");
		}
	}



	/*****************************************************************/
	@Override
	protected void Qq() {

		if (!ExecutorsService.isUiThread()) {
			super_Qq();
			return;
		}
		executorsService.submit(new Runnable(){
				@Override
				public void run() {
					super_Qq();
				}
			});
	}

	protected void super_Qq() {
		this.Hw.clear();
		//this.FH = new HashMap<>();
		this.FH.clear();

		if (this.j6 != null) {
			this.DW.U2(this.j6, this.FH, this.Hw);
		}
	}


	/*****************************************************************/

	protected void super_et(List<String> list, boolean p) {
		if (this.DW != null) {
			this.DW.cn(list, p);
		}
	}
	@Override
	public void et(final List<String> list, final boolean p) {
		if (!ExecutorsService.isUiThread()) {
			super_et(list, p);
			return;
		}

		executorsService.submit(new Runnable(){
				@Override
				public void run() {
					super_et(list, p);
				}
			});
	}

	/*****************************************************************/
	public void Ws() {
        try {
            if (this.j6 != null) {
				saveCurrentAppHome(null);
                App.J0().aM();
                App.aM().Hw();
                App.getOpenFileService().Zo();
                this.Hw.clear();
				//this.FH = new HashMap<>();
				this.FH.clear();

                App.getDebugger().v5();
                App.getMainActivity().q7();

                jJ();
            }
        }
		catch (Throwable th) {
			th.printStackTrace();
        }
    }
	/*****************************************************************/
	@Override
	public void wc() {
		if (!ExecutorsService.isUiThread()) {
			super_wc();
			return;
		}
		executorsService.submit(new Runnable(){
				@Override
				public void run() {
					super_wc();
				}
			});
	}

	private void super_wc() {
		if (this.j6 != null && getProjectSupport(this.j6) == null) {
			Ws();
		}
		if (this.j6 != null) {
			Qq();
		}
		jJ();
	}

	/*****************************************************************/

	public void super_CU() {
		if (this.j6 != null 
			&& getProjectSupport(this.j6) == null) {
			Ws();
		}
		App.getDebugger().ef();
		if (this.j6 != null) {
			App.aj(new Runnable(){
					@Override
					public void run() {
						App.sy(App.getMainActivity(), "Reloading project...", new e(), new f());
					}
				});
		} else {
			Qq();
			jJ();
		}

	}
	@Override
	public void CU() {

		if (!ExecutorsService.isUiThread()) {
			super_CU();
			return;
		}

		executorsService.submit(new Runnable(){
				@Override
				public void run() {
					super_CU();
				}
			});
	}
	/*****************************************************************/

	/*****************************************************************/
	public List<BuildGradle.MavenDependency> qp() {
		ArrayList<BuildGradle.MavenDependency> arrayList = new ArrayList<>();
		for (String str : App.getProjectService().BT().keySet()) {
			if (GradleTools.isGradleProject(str)) {
				for (BuildGradle.Dependency mavenDependency : k2(str)) {
					if (mavenDependency instanceof BuildGradle.MavenDependency) {
						Iterator it = App.getMavenService().er(getFlatRepositoryPathMap(str), ((BuildGradle.MavenDependency)mavenDependency)).iterator();
						while (it.hasNext()) {
							arrayList.add((BuildGradle.MavenDependency) it.next());
						}
					}
				}
			}
		}
		return arrayList;

	}

	private Map<String, String> getFlatRepositoryPathMap(String str) {
		HashMap<String, String> hashMap = new HashMap<>();
		for (BuildGradle.Repository flatLocalRepository : ZeroAicyExtensionInterface.getBuildGradle().getConfiguration(GradleTools.Zo(str)).curProjectsRepositorys) {
			if (flatLocalRepository instanceof BuildGradle.FlatLocalRepository) {
				hashMap.put(((BuildGradle.FlatLocalRepository)flatLocalRepository).getFlatDir(str), GradleTools.EQ(str));
			}
		}
		return hashMap;
	}
	private static List<BuildGradle.Dependency> k2(String str) {
		BuildGradle configuration = ZeroAicyExtensionInterface.getBuildGradle().getConfiguration(GradleTools.Zo(str));
		String P8 = GradleTools.P8(str);
		if (FileSystem.isFileAndNotZip(P8)) {
			BuildGradle configuration2 = ZeroAicyExtensionInterface.getBuildGradle().getConfiguration(P8);
			if (configuration2.subProjectsDependencies.size() > 0 || configuration2.allProjectsDependencies.size() > 0) {
				ArrayList<BuildGradle.Dependency> arrayList = new ArrayList<>();
				for (BuildGradle.Dependency dependency : configuration2.subProjectsDependencies) {
					if (dependency instanceof BuildGradle.MavenDependency) {
						arrayList.add(dependency);
					}
				}
				for (BuildGradle.Dependency dependency2 : configuration2.allProjectsDependencies) {
					if (dependency2 instanceof BuildGradle.MavenDependency) {
						arrayList.add(dependency2);
					}
				}
				arrayList.addAll(configuration.dependencies);
				return arrayList;
			}
		}
		return configuration.dependencies;

	}

	private static List<BuildGradle.RemoteRepository> WB(String str) {
		ArrayList<BuildGradle.RemoteRepository> arrayList = new ArrayList<>();
		if (GradleTools.isGradleProject(str)) {
			for (BuildGradle.Repository remoteRepository : ZeroAicyExtensionInterface.getBuildGradle().getConfiguration(GradleTools.Zo(str)).curProjectsRepositorys) {
				if (remoteRepository instanceof BuildGradle.RemoteRepository) {
					arrayList.add((BuildGradle.RemoteRepository)remoteRepository);
				}
			}
			String P8 = GradleTools.P8(str);
			if (FileSystem.isFileAndNotZip(P8)) {
				BuildGradle configuration = ZeroAicyExtensionInterface.getBuildGradle().getConfiguration(P8);
				for (BuildGradle.Repository remoteRepository2 : configuration.allProjectsRepositorys) {
					if (remoteRepository2 instanceof BuildGradle.RemoteRepository) {
						arrayList.add((BuildGradle.RemoteRepository)remoteRepository2);
					}
				}
				for (BuildGradle.Repository remoteRepository3 : configuration.subProjectsRepositorys) {
					if (remoteRepository3 instanceof BuildGradle.RemoteRepository) {
						arrayList.add((BuildGradle.RemoteRepository)remoteRepository3);
					}
				}
			}
		}
		return arrayList;

	}

	Runnable DW_Hw = new Runnable(){
		@Override
		public void run() {
			final ArrayList<BuildGradle.MavenDependency> arrayList = new ArrayList<>();
			arrayList.addAll(qp());
			if (arrayList.isEmpty()) {
				return;
			}
			App.aj(new Runnable(){
					@Override
					public void run() {
						App.getNativeCodeSupportService().a8(App.gn(), 
							arrayList, 
							WB(App.getProjectService().getCurrentAppHome()), 
							new Runnable(){
								@Override
								public void run() {
									App.getMavenService().FH();
									App.getProjectService().CU();
								}
							});
					}
				});
			
		}
	};
	@Override
	public boolean sG() {

		if (this.DW instanceof AndroidProjectSupport) {
			executorsService.submit(DW_Hw);
			return true;
		}
		Log.d("sG()", Thread.currentThread().getStackTrace()[3]);
		if (this.DW != null) {
			return this.DW.Hw();
		}
		return false;
	}

	/*****************************************************************/

	// FireBaseLogEvent??
	public void sy(String str) {
		HashMap<String,String> hashMap = new HashMap<>();
		hashMap.put("isPremium", Boolean.toString(ca()));
		hashMap.put("libraryCount", Integer.toString(this.BT().size()));
		hashMap.put("referrer", str); // 来自
		if (AndroidProjectSupport.iW(getCurrentAppHome())) {
			hashMap.put("package", AndroidProjectSupport.kQ(getCurrentAppHome(), (String) null));
		}
		FireBaseLogEvent.EQ("Project opened", hashMap);
    }

	private void saveCurrentAppHome(String str) {
		this.j6 = null;
		SharedPreferences.Editor edit = App.getContext().getSharedPreferences("ProjectService", 0).edit();
		edit.putString("CurrentAppHome", str);
		edit.commit();
	}


	private ProjectSupport getProjectSupport(String str) {
		if (str == null) {
			return null;
		}
		for (ProjectSupport projectSupport : App.getProjectSupports()) {
			if (projectSupport.er(str)) {
				return projectSupport;
			}
		}
		return null;
    }
}
